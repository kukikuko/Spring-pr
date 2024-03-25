package com.in28minutes.springboot.learnjpaandhibernate.couse;

import com.in28minutes.springboot.learnjpaandhibernate.couse.Course;
import com.in28minutes.springboot.learnjpaandhibernate.couse.jdbc.CourseJdbcRepository;
import com.in28minutes.springboot.learnjpaandhibernate.couse.jpa.CourseJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private CourseJdbcRepository repository;

    @Autowired
    private CourseJPARepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1, "Learn AWS JPA", "in28minutes"));
        repository.insert(new Course(2, "Learn Azure JPA", "in28minutes"));
        repository.insert(new Course(3, "Learn DevOps Now", "in28minutes"));

        repository.deleteById(1);

        System.out.println(repository.findById(2));
        System.out.println(repository.findById(3));
    }
}
