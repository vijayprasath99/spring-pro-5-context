package com.vj.prospring5.application.factorybean;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        GenericApplicationContext ctx = new GenericXmlApplicationContext("classpath:application-context/factorybean.xml");
        
        MessageDigester digester = ctx.getBean(MessageDigester.class);
        digester.digest("helloWorld");
    }
}
