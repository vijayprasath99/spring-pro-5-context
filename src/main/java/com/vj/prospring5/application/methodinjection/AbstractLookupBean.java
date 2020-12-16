package com.vj.prospring5.application.methodinjection;

public abstract class AbstractLookupBean implements DemoBean {
    public abstract Singer getSinger();

    @Override
    public void doSomething() {
        getSinger().sing();
    }
}
