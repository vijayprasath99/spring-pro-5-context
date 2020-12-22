package com.vj.prospring5.application.aliasbyconfiguration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;

import java.util.Arrays;
import java.util.Map;

import static com.vj.prospring5.util.PrintHelper.delimitLine;

public class Application {

    @Configuration
    public static class ApplicationConfig {
        @Bean({"john,1", "john2"})
        public Singer pokemon() {
            return new Singer();
        }
    }

    public static void main(String[] args) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        Map<String, Singer> beans = ctx.getBeansOfType(Singer.class);

        delimitLine();

        beans.entrySet().stream().forEach((entrySet) -> {
            String id = entrySet.getKey();
            System.out.printf("%s | %s%n", id, getAliasFor(id, ctx));
        });
    }

    private static String getAliasFor(String id, GenericApplicationContext ctx) {
        String[] alias = ctx.getAliases(id);
        return Arrays.toString(alias);
    }
}
