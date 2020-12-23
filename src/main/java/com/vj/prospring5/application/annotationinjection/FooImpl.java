package com.vj.prospring5.application.annotationinjection;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.BeanNameAware;

public class FooImpl implements Foo, BeanNameAware {
    String beanName;

    @Override
    public void init() {
        System.out.println("::: init() " + toString());
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("::: postConstruct() " + toString());
    }


    @Override
    public String toString() {
        return "FooImpl{" +
                "beanName='" + beanName + '\'' +
                '}';
    }
}
