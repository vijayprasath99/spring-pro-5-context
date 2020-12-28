package com.vj.prospring5.application.injectcollectionbyannotation;

import org.springframework.context.support.GenericXmlApplicationContext;

public class InjectableCollectionByAnnotation {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:application-context-InjectableCollectionByAnnotation.xml");
        ctx.refresh();

        InjectionViaAnnotationService service = ctx.getBean(InjectionViaAnnotationService.class);
//        Set<String> aSet = ctx.getBean("aFuckingSet", Set.class);
//        System.out.println("__________________________" + aSet.toString());
        service.print();

        ctx.close();
    }
}
