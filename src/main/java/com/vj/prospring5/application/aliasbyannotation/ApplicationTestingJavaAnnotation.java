package com.vj.prospring5.application.aliasbyconfiguration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;

import java.lang.annotation.Annotation;
import java.util.Arrays;

import static com.vj.prospring5.util.PrintHelper.delimitLine;

public class ApplicationTestingJavaAnnotation {

    @Configuration
    public static class ApplicationConfig {
        @Bean({"john1", "john2"})
        public Singer pokemon() {
            return new Singer();
        }
    }

    public static void main(String[] args) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        delimitLine();

        Singer john1 = ctx.getBean("john1", Singer.class);
        Annotation awardAnnotation = Singer.class.getAnnotation(Award.class);

        if (awardAnnotation instanceof Award) {
            Award john1Award = (Award) awardAnnotation;
            System.out.println(stringify(john1Award, "john1"));
        } else {
            System.out.println("Not an instance of award");
        }
    }

    public static String stringify(Award award, String name) {
        String[] prize = award.prize();
        return String.format("%s:%s", name, Arrays.toString(prize));
    }

}
