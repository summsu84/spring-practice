package com.teamjw.bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanMainApp {
    public static void main(String[] args) {

        // Bean Java Config을 사용하여 빈 등록 및 테스트
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        BeanTest beanTest = (BeanTest) context.getBean("beanTest");
        beanTest.setMessage("Test");
        beanTest.getMessage();
        context.close();
        // XML을 이용하여 생성
        AbstractApplicationContext context2 = new ClassPathXmlApplicationContext("com/teamjw/xml/beans.xml");
        BeanTest beanTest2 = (BeanTest) context2.getBean("helloWorld");
        beanTest2.getMessage();
        context.close();




    }
}
