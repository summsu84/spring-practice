package com.teamjw;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *  Configuration Annotation 사용한 Bean 등록
 *  XML 파일은 생성하지 않으며, 해당 클래스 파일의 @Bean 에 해당하는 메서드를 이름을 이름으로 하여 빈에 등록 시킨다.
 *  해당 클래스를 스캔 하기 위해서는, 우선 IoC 컨테이너를 인스턴스화해야 한다. 왜냐 하면, 스프링이 @Configuration 및 @Bean을 발견하고
 *  나중에, 컨테이너로 부터 빈을 가져올 수 있기 때문이다.
 */
@Configuration
public class SequenceGeneratorConfiguration {

    @Bean
    public SequenceGenerator sequenceGenerator() {
        SequenceGenerator seqgen = new SequenceGenerator();
        seqgen.setPrefix("30");
        seqgen.setSuffix("A");
        seqgen.setInitial(100000);
        return seqgen;
    }
}
