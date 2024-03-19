package com.in28minutes.learnspringframework.helloWorld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {
    public static void main(String[] args) {
        //Launch a Spring Context
        try( var context =
                     new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)) {

            //Configure the things that we wantSpring to manage - @Configuration
            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("age"));

            System.out.println(context.getBean("person"));
            System.out.println(context.getBean("personMethodCall"));
            System.out.println(context.getBean("personParameters"));
            System.out.println(context.getBean("personQualifier"));

            System.out.println(context.getBean("address2"));
            System.out.println(context.getBean(Address.class));
            System.out.println(context.getBean(Person.class));

//        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        }
    }
}
