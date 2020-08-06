package com.teamjw;

import com.sun.org.apache.xerces.internal.impl.XML11NamespaceBinder;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class HelloWorldApp {

    public static void main(String[] args) {
        // XmlBeanFactory 사용
        XmlBeanFactory factory = new XmlBeanFactory (new ClassPathResource("beans.xml"));
        HelloWorld obj = (HelloWorld) factory.getBean("helloWorld");
        obj.getMessage();

        // BeanFactory를 이용한 Bean Loading
        Resource resource = new ClassPathResource("beans.xml");
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("beans.xml");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

        HelloBean helloBean = (HelloBean) beanFactory.getBean("helloBean");
        helloBean.getMessage();

        HelloBean helloBean1 =  (HelloBean) applicationContext.getBean("helloBean");
        helloBean1.getMessage();

    }
}
