package com.in28minutes.springboot.myfirstwebapp.todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Integer> {

    public List<Todo> findByUserName(String userName);
}
