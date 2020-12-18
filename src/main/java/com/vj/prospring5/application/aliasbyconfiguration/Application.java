package com.vj.prospring5.application.aliasbyconfiguration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static com.vj.prospring5.application.util.PrintHelper.delimitLine;

public class Application {

    @Configuration
    @ComponentScan(value = "com.vj.prospring5.application.aliasbyconfiguration")
    public static class ApplicationConfig {}

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        Map<String, Singer> beans = ctx.getBeansOfType(Singer.class);

        delimitLine();

        beans.entrySet().stream().forEach((entrySet) -> {
            System.out.println(entrySet.getKey());
        });
    }
}
