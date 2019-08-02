package com.teamjw.redis.config;

import com.teamjw.redis.vo.RedisVo;
import jdk.nashorn.internal.objects.annotations.Property;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

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

    // jedis 사용 시
/*    @Bean
    public JedisConnectionFactory jedisConnectionFactory(){
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(redisHostName, Integer.parseInt(redisPort));
        redisStandaloneConfiguration.setDatabase(14);
        JedisConnectionFactory factory = new JedisConnectionFactory(redisStandaloneConfiguration);

        return factory;
    }*/

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {

        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
        redisTemplate.setConnectionFactory(redisConnectionFactory());
        /*        redisTemplate.setConnectionFactory(jedisConnectionFactory());  jedis 사용 시 */
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(RedisVo.class));
        return redisTemplate;
    }




}
