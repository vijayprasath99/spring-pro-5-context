package com.vj.prospring5.application.methodreplace;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:application-context/methodreplace.xml");
        ctx.refresh();

        ReplacementTarget replaced = ctx.getBean("replacedTarget", ReplacementTarget.class);
        ReplacementTarget original = ctx.getBean("originalTarget", ReplacementTarget.class);

        Object msg = new StringBuilder("hello world!");

        System.out.println(replaced.formatMessage(msg));
        System.out.println(original.formatMessage(msg));

    }
}
