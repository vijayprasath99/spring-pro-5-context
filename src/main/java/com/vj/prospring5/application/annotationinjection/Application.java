package com.vj.prospring5.application.annotationinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Component;

import static com.vj.prospring5.util.PrintHelper.delimitLine;

@Component
@Lazy
public class Application {

    @Configuration
    @ComponentScan("com.vj.prospring5.application.annotationinjection")
    public static class ApplicationConfig {

//        @Lazy
        @Bean(initMethod = "init")
        public Foo foo1Impl() {
            return new FooImpl();
        }

//        @Lazy
        @Bean(initMethod = "init")
        public Foo foo2Impl() {
            return new FooImpl();
        }
    }

    Foo foo1;
    Foo foo2;
    Bar bar;

    public Application() {
        System.out.println("::: Application() called!");
    }

    public Application(Foo foo1) {
//        System.out.println("::: Application(foo1) called!");
        this.foo1 = foo1;
    }

    public Application(Foo foo1, Bar bar) {
//        System.out.println("::: Application(foo1,bar) called!");
        this.foo1 = foo1;
        this.bar = bar;
    }

    @Autowired
    @Qualifier("foo1Impl")
    public void setFoo1(Foo foo1) {
//        System.out.println("::: setFoo1(foo) called!");
        this.foo1 = foo1;
    }

    @Autowired
    @Qualifier("foo2Impl")
    public void setFoo2(Foo foo2) {
//        System.out.println("::: setFoo2(foo) called!");
        this.foo2 = foo2;
    }

    @Autowired
    public void setBar(Bar bar) {
//        System.out.println("::: setBar(bar) called!");
        this.bar = bar;
    }

    public static void main(String[] args) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        delimitLine();
        Application application = ctx.getBean(Application.class);
        delimitLine();

        ctx.close();

    }
}
