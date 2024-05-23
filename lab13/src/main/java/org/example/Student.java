package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class Student {
    @Value("${student.name}")
    private String name;
    @Value("${student.last_name}")
    private String last_name;
    @Value("${student.group}")
    private String group;

    @PostConstruct
    public void init() {
        System.out.println(name + " " + last_name + " " + group);
    }
}
