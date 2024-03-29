package com.in28minutes.learnspringframework.example.c1;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

//@Component
@Primary
@Repository
public class MongoDbDateService implements DataService {
    @Override
    public int[] retrieveDate() {
        return new int[]{11, 22, 33, 44, 55};
    }
}
