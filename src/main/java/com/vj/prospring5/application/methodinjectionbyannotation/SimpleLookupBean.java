package com.vj.prospring5.application.methodinjectionbyannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("simpleLookupBean")
public class SimpleLookupBean implements DemoBean {

    Singer singer;

    @Autowired
    @Qualifier("singer")
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
