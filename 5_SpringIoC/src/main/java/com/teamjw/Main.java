package com.teamjw;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    public static void main(String [] args)
    {
        /**
         *  BeanFactory를 상속받는 ApplicationContext를 통해서 이를 구현한 여러 Context 클래스가 존재한다.
         *  해당, 예제에서는 최근 작성된 AnnotationConfigApplicationContext를 활용한다.
         *  ApplicationContext로 부터 빈을 가져올수 있게 된다.
         */
        ApplicationContext context = new AnnotationConfigApplicationContext(SequenceGeneratorConfiguration.class);

        SequenceGenerator generator = context.getBean(SequenceGenerator.class);

        System.out.println(generator.getSequence());
        System.out.println(generator.getSequence());
    }
}
