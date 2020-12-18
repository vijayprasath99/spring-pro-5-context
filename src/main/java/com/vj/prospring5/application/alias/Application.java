package com.vj.prospring5.application.alias;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Map;

import static com.vj.prospring5.constant.ApplicationConfigurationConstants.APPLICATION_CONTEXT_DIR;

public class Application {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load(APPLICATION_CONTEXT_DIR + "alias.xml");
        ctx.refresh();

        Map<String, String> beans = ctx.getBeansOfType(String.class);

        System.out.println("===============================================");
        System.out.println(beans.size());
    }
}
