package com.vj.prospring5.application.factorybean;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.security.MessageDigest;

import static com.vj.prospring5.util.PrintHelper.delimitLine;

public class Application {
    public static void main(String[] args) throws Exception {
        GenericApplicationContext ctx = new GenericXmlApplicationContext("classpath:application-context/factorybean.xml");

        String input = "hello world";

        delimitLine();

        MessageDigester digester = ctx.getBean("messageDigester", MessageDigester.class);
        digester.digest(input);

        delimitLine();

        MessageDigester digesterV2 = ctx.getBean("messageDigesterV2", MessageDigester.class);
        digesterV2.digest(input);

        delimitLine();
    }
}
