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