package com.vj.prospring5.application.methodinjection;

public class SimpleLookupBean implements DemoBean {
    Singer singer;

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    @Override
    public Singer getSinger() {
        return this.singer;
    }

    @Override
    public void doSomething() {
        this.singer.sing();
    }
}
