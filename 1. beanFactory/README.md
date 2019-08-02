# 스프링 IoC 컨테이너

## 개요

	- 스프링 컨테이너는 스프링 프레임워크의 핵심이며, 오브젝트를 생성하고, 설정하고, 생성에서 종료까지 라이프 사이클을 관리
	- 스프링 컨테이너는 DI 를 사용하여 컴포넌트들을 관리 하며, 이렇게 관되는 컴퍼넌트 또는 객체를 스프링 빈이라고 정의 한다.
	- 스프링 컨테이너는 메타데이터를 통해서 빈을 생성하고, 설정하고 조립하는 정보를 알게 되며, 이러한 메타 데이터는 XML, Java Annotation, 또는 Java Configuration Code를 통해서 얻게 된다.
	- 즉, 스프링 컨테이너(IoC 컨테이너)는 미리 정의된 메타 데이터를 이용하여, 빈을 생성하고, 조립하고 관리하게 되는데 이를 스프링 프레임워크라고 정의 한다.
	- BeanFactory를 상속 받으며, BeanFactory의 모든 기능을 포함하고 있으며, BeanFactory 보다 추천 사용된다.
    - ** 스프링 빈 생성시 가장 중요한 핵심 요소로 BeanFactory와 ApplicationContext가 있으며, 이를 통해서 빈을 생성 및 관리를 하게 된다. **

## BeanFactory and Application Context
### BeanFactory
- 스프링 빈의 핵심 요소이자 최상단 인터페이스로, 기본적인 DI를 지원하는 기능 한다.
- BeanFactory는 getBean() 요청 시 인스턴스를 생성하게 된다.
### ApplicationContext
#### ApplicationContext 구현체
- FileSystemXmlApplicationContext
    - 해당 컨테이너는 XML으로 부터 빈을 가져온다. XML 빈 설정과 생성자에 관한 정보를 작성해야 한다.
    
```java

public class MainApp {
    public static void main(String [] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext("C:/User/Beans.xml");
        
        HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
        helloWorld.getMessage();
    }
}

```


- ClassPathXmlApplicationContext
    - 해당 컨테이너는 CLASSPATH 에 있는 Bean 설정 파일을 가져온다.
    

- WebXmlApplicationContext
    - 웹 어플리케이션 내의 모든 빈 정의를 XML 로 부터 가져온다.
