package com.vj.prospring5.application.methodinjection;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class MethodInjectionApplication {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:application-context/MethodInjectionApplication.xml");
        ctx.refresh();

        SimpleLookupBean simpleLookupBean = ctx.getBean(SimpleLookupBean.class);
        AbstractLookupBean abstractLookupBean = ctx.getBean(AbstractLookupBean.class);

        displayInfo("simpleLookupBean", simpleLookupBean);
        displayInfo("abstractLookupBean", abstractLookupBean);

        ctx.close();
    }

    private static void displayInfo(String beanName, DemoBean bean) {
        System.out.printf("----------------START:%s-----------------------%n", beanName);
        Singer singer1 = bean.getSinger();
        Singer singer2 = bean.getSinger();

        System.out.printf("Comparing 2 singers, result: %b%n", singer1 == singer2);

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        for(int i = 0; i < 5; i++) {
            bean.getSinger().sing();
        }

        stopWatch.stop();
        System.out.printf("Stopwatch result to get bean: %s%n", stopWatch.toString());
        System.out.printf("----------------STOP:%s-----------------------%n", beanName);
    }
}
