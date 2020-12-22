package com.vj.prospring5.application.xmlinjection;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Map;

import static com.vj.prospring5.constant.ApplicationConfigurationConstants.APPLICATION_CONTEXT_DIR;
import static com.vj.prospring5.util.PrintHelper.delimitLine;

public class Application {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load(APPLICATION_CONTEXT_DIR + "xmlinjection.xml");
        ctx.refresh();

        delimitLine();


    }
}
