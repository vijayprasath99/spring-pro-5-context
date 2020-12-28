package com.vj.prospring5.application.helloworld;

import com.vj.prospring5.service.HelloWorldMessageProvider;
import com.vj.prospring5.service.MessageProvider;
import com.vj.prospring5.service.MessageRenderer;
import com.vj.prospring5.service.StandardOutMessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorld {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.vj.prospring5");
        MessageRenderer mr = context.getBean("renderer", MessageRenderer.class);

        mr.render();
    }
}
