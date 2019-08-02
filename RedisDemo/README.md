# Spring Data Redis Sample

## 개요

	- 스프링 부트를 이용하여, 세션 정보를 Redis에 저장하고, 요청 시 Redis로 부터 세션 정보를 가져온다.
	- 해당 예제에서는 Jedis가 아닌 Spring Boot Data Redis를 사용하여 Redis 테스트를 수행한다.

## 의존성 추가
    - 아래와 같이 Spring Data Redis를 추가한다.
    
```xml
   
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-redis</artifactId>
        <version>2.1.4.RELEASE</version>
    </dependency>

``` 

## Configuration
	- Configuration 클래스를 통해서, RedisConnectionFactory 인터페이스를 확장한 LettuceConnectionFactory 또는 JedisConnectionFactory를 생성해서 빈으로 등록한다.
	- 해당 예제에서는 LettuceConnectionFactory를 사용한다.

###application.properties 설정

```properties

spring.redis.host = ip address
spring.redis.password=
spring.redis.port=6379


```

### Configuration Class 생성

    - Java Configuration을 통해서 Bean을 등록하며, application.properties 정보를 읽어, hostname 및 port를 설정한다.
	- Spring Data Redis 2.0 이후 부터, RedisStandaloneConfiguration 클래스를 사용하여 Redis 설정정보를 저장하고, 이를 LuttuceConnectionFactoruy 에 주입 해야 한다.
	
```java

@Configuration
@PropertySource("application.properties")
public class RedisConfiguration {

    @Value("${spring.redis.host}")
    private String redisHostName;
    @Value("${spring.redis.port}")
    private String redisPort;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }


    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        // Spring Data Redis 2.0 부터 RedisStandaloneConfiguration 사용
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(redisHostName, Integer.parseInt(redisPort));
        redisStandaloneConfiguration.setDatabase(14);
        LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory(redisStandaloneConfiguration);

        return lettuceConnectionFactory;
    }
    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
        redisTemplate.setConnectionFactory(redisConnectionFactory());
        return redisTemplate;
    }
}

```

## 로직 생성
    - 해당 테스트에서는 /redis get 메서드 호출 시, 서비스 레이어에서 임의의 값을 저장 하는 형태로 진행한다.

### Controller 생성 (RedisController.java)

```java

package com.teamjw.redis.controller;

import com.teamjw.redis.service.RedisService;
import com.teamjw.redis.vo.RedisVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RedisController {

    @Autowired
    private RedisService redisService;

    private static final Logger logger = LoggerFactory.getLogger(RestController.class);

   
    @RequestMapping(value = "/test/save", method = RequestMethod.GET)
    public RedisVo saveRedisTest() {

        return redisService.redisSaveTest();
    }

    
    @RequestMapping(value = "/test/get", method = RequestMethod.GET)
    public RedisVo getRedisTest() {

        return redisService.redisGetTest();
    }
}


```

### Service 생성 (RedisService.java)

```java

package com.teamjw.redis.service;

import com.teamjw.redis.vo.RedisVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    public RedisVo redisSaveTest() {

        ValueOperations<String, Object> vop = redisTemplate.opsForValue();

        RedisVo redisVo = new RedisVo();
        redisVo.setName("테스트");
        redisVo.setId("TEST");

        // Redis Setting
        vop.set("user", redisVo);

        return redisVo;
    }

    public RedisVo redisGetTest() {

        ValueOperations<String, Object> vop = redisTemplate.opsForValue();

        RedisVo redisVo = (RedisVo) vop.get("user");

        return redisVo;
    }

}

```

### VO 생성 (RedisVo.java)

```java

package com.teamjw.redis.vo;

import java.io.Serializable;

public class RedisVo implements Serializable {

    private String name;
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}


```


## 테스트

    - /redis/save
        - vo를 저장한다.
    - /redis/get
        - vo를 가져온다.

## 확인 사항

    - 실제로 redis db에 위와 같은 RedisConfig 설정하게 되면, 아래와 같이 key:value가 저장된다.

```json

\xAC\xED\x00\x05t\x00\x04user : ▲▲

```

### Configuration 수정
    - 위와 같이 저장되는 것을 수정하기 위해서, RedisConfiguration 의 bean을 수정 후 redis db를 확인하면 원하는 포맷으로 나타나는 것을 확인 할 수 있다.

```java

  @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
        redisTemplate.setConnectionFactory(redisConnectionFactory());
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(RedisVo.class));
        return redisTemplate;
    }

```

    - 위와 같이 수정 후 redis db를 확인하면 아래와 같은 포맷으로 저장된것을 확인 할 수 있다.

```json

user : 
{
"name": "테스트",
"id": "TEST"
}

```



