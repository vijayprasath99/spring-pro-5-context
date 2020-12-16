package com.vj.prospring5.application.methodinjectionbyannotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;

public class MethodInjectionByAnnotation {

    @Configuration
    @ComponentScan("com.vj.prospring5.application.methodinjectionbyannotation")
    public static class MethodInjectionByAnnotationConfig {}

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MethodInjectionByAnnotationConfig.class);
        SimpleLookupBean simpleLookupBean = ctx.getBean(SimpleLookupBean.class);
        AbstractLookupBean abstractLookupBean = ctx.getBean(AbstractLookupBean.class);

        int totalBeans = 10000;
        long simpleLookupBeanTime = displayInfo("simpleLookupBean", simpleLookupBean, totalBeans);
        long abstractLookupBeanTime = displayInfo("abstractLookupBean", abstractLookupBean, totalBeans);

        System.out.printf("Simple bean time: %d, abstract bean time: %d %n", simpleLookupBeanTime, abstractLookupBeanTime);
    }

    private static long displayInfo(String beanName, DemoBean bean, int totalBeans) {
        System.out.printf("----------------START:%s-----------------------%n", beanName);
        Singer singer1 = bean.getSinger();
        Singer singer2 = bean.getSinger();

        System.out.printf("Comparing 2 singers, result: %b%n", singer1 == singer2);

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        for(int i = 0; i < totalBeans; i++) {
            bean.getSinger().sing();
        }

        stopWatch.stop();
        System.out.printf("Stopwatch result to get bean: %s%n", stopWatch.toString());
        System.out.printf("----------------STOP:%s-----------------------%n", beanName);

        return stopWatch.getTotalTimeMillis();
    }
}
