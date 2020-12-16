package com.vj.prospring5.application.methodinjectionbyannotation;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component("abstractLookupBean")
public class AbstractLookupBean implements DemoBean {

    @Lookup("singer")
    public Singer getSinger() {
        return null;
    }

    @Override
    public void doSomething() {
        getSinger().sing();
    }
}
