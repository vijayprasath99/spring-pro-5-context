package com.vj.prospring5.application.javaconfiguration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

import static com.vj.prospring5.util.PrintHelper.delimitLine;

public class Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(ApplicationConfig.class);

        Map<String, MessageRenderer> renderers = ctx.getBeansOfType(MessageRenderer.class);

        delimitLine();

        renderers.values().stream().forEach(renderer -> renderer.render());
    }
}
