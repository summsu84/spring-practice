package com.teamjw.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Config
@Configuration
public class BeanConfig {
    @Bean(name="beanTest")
    public BeanTest beanTest() {
        return new BeanTest();
    }
}
