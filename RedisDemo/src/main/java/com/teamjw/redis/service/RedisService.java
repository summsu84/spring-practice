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
