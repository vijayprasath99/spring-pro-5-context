package com.vj.prospring5.application.xmlinjection;

import org.springframework.context.support.GenericXmlApplicationContext;

import static com.vj.prospring5.constant.ApplicationConfigurationConstants.APPLICATION_CONTEXT_DIR;
import static com.vj.prospring5.util.PrintHelper.delimitLine;

public class Target {
    private Foo foo1;
    private Foo foo2;
    private Bar bar;

    public Target() {
        System.out.println("::: Target() called!");
    }

    public Target(Foo foo1) {
        System.out.println("::: Target(foo) called!");
        this.foo1 = foo1;
    }

    public Target(Foo foo1, Bar bar) {
        System.out.println("::: Target(foo, bar) called!");
        this.foo1 = foo1;
        this.bar = bar;
    }

    public void setFoo1(Foo foo1) {
        System.out.println("::: setFoo1(foo) called!");
        this.foo1 = foo1;
    }

    public void setFoo2(Foo foo2) {
        System.out.println("::: setFoo2(foo) called!");
        this.foo2 = foo2;
    }

    public void setBar(Bar bar) {
        System.out.println("::: setBar(bar) called!");
        this.bar = bar;
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load(APPLICATION_CONTEXT_DIR + "xmlinjection.xml");
        ctx.refresh();

        delimitLine();

        Target t = null;

        System.out.println("Using by name:");
        t = ctx.getBean("targetByName", Target.class);
        System.out.println(t.toString());
        System.out.println();

        System.out.println("Using by type:");
        t = ctx.getBean("targetByType", Target.class);
        System.out.println(t.toString());
        System.out.println();

        System.out.println("Using by constructor:");
        t = ctx.getBean("targetConstructor", Target.class);
        System.out.println(t.toString());
        System.out.println();

        delimitLine();

        ctx.close();
    }

    @Override
    public String toString() {
        return "Target{" +
                "foo1=" + foo1 +
                ", foo2=" + foo2 +
                ", bar=" + bar +
                '}';
    }
}
