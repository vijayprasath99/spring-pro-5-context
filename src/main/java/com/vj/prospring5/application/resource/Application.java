package com.vj.prospring5.application.resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import java.io.File;

import static com.vj.prospring5.util.PrintHelper.delimitLine;

public class Application {
    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext();

        File file = File.createTempFile("test", "txt");
        file.deleteOnExit();

        delimitLine();

        Resource filePathResource = ctx.getResource("file://" + file.getPath());
        displayInfo(filePathResource);

        Resource classPathResource = ctx.getResource("classpath:labels_en.properties");
        displayInfo(classPathResource);

        Resource urlResource = ctx.getResource("https://www.google.com");
        displayInfo(urlResource);

        delimitLine();
    }

    public static void displayInfo(Resource res) throws Exception {
        System.out.println(res.getClass());
        System.out.println(res.getURL().getContent());
        System.out.println("");
    }
}
