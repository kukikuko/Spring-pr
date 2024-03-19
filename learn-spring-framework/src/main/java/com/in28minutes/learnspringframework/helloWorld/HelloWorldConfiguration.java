package com.in28minutes.learnspringframework.helloWorld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person (String name, int age, Address address) {};
record Address (String firstLine, String city) {};

@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String name() {
        return "Range";
    }

    @Bean
    public int age() {
        return 15;
    }

    @Bean
    public Person person() {
        return new Person("Ravi", 20, new Address("TU", "Seoul"));
    }

    @Bean
    public Person personMethodCall() {
        return new Person(name(), age(), address());
    }

    @Bean
    public Person personParameters(String name, int age, Address address3) {//name, age, address
        return new Person(name, age, address3);
    }

    @Bean
    @Primary
    public Person personParameters2(String name, int age, Address address) {//name, age, address
        return new Person(name, age, address);
    }

    @Bean
    public Person personQualifier(String name, int age, @Qualifier("address3Qualifier") Address address) {//name, age, address
        return new Person(name, age, address);
    }

    @Bean(name = "address2")
    @Primary
    public Address address() {
        return new Address("Begun", "PT");
    }

    @Bean
    @Qualifier("address3Qualifier")
    public Address address3() {
        return new Address("PT", "IN");
    }

}
