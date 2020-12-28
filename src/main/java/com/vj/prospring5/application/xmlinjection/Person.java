package com.vj.prospring5.application.xmlinjection;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Person implements DisposableBean {
    private String name;
    private int age = Integer.MIN_VALUE;

//    public void init() {
//        if (age == Integer.MIN_VALUE) {
//            throw new IllegalArgumentException("Must set age!");
//        }
//        System.out.println(String.format("::: init() %s", toString()));
//    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    
    @Override
    public void destroy() {
        System.out.println("::: destroy() " + toString());
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("::: afterPropertiesSet() " + toString());
    }
}
