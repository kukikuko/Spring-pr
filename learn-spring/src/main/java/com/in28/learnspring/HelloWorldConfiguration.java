package com.in28.learnspring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

record Person(String name, int age, Address address) {};
record Address(String firstLine, String city) {};

@Configuration
public class HelloWorldConfiguration {

   @Bean
   public String name() {
      return "Han";
   }

   @Bean
   public int age() {
      return 28;
   }

   @Bean
   public Person person() {
      return new Person("Kang", 24, new Address("asdf", "Asdf"));
   }

   @Bean
   public Person person2() {
      return new Person(name(), age(), address());
   }

   @Bean
   public Person person3(String name, int age, Address address) {
      return new Person(name, age, address);
   }

   @Bean
   public Address address() {
      return new Address("BJ", "PK");
   }


}
