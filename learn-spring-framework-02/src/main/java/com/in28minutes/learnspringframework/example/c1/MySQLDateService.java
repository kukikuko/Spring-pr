package com.in28minutes.learnspringframework.example.c1;

import org.springframework.stereotype.Repository;

//@Component
@Repository
public class MySQLDateService implements DataService{
    @Override
    public int[] retrieveDate() {
        return new int[] {1, 2, 3, 4, 5};
    }
}
