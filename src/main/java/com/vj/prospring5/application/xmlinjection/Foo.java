package com.vj.prospring5.application.xmlinjection;

import org.springframework.beans.factory.BeanNameAware;

public class Foo implements BeanNameAware {
    
    String beanName;
    
    public void destroy() throws Exception {
        System.out.println("::: destroy() " + toString());
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    @Override
    public String toString() {
        return "Foo{" +
                "beanName='" + beanName + '\'' +
                '}';
    }
}
