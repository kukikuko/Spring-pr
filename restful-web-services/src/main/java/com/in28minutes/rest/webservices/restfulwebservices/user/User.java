package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;

public class User {
    private Integer id;
    private String name;
    private LocalDate brithDate;

    public User(Integer id, String name, LocalDate brithDate) {
        this.id = id;
        this.name = name;
        this.brithDate = brithDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBrithDate() {
        return brithDate;
    }

    public void setBrithDate(LocalDate brithDate) {
        this.brithDate = brithDate;
    }

    public String toString() {
        return String.format("id: %s, name: %s, brithDate: %s", id, name, brithDate);
    }
}
