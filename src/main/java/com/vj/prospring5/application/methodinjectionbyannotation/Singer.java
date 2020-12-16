package com.vj.prospring5.application.methodinjectionbyannotation;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component("singer")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Singer {

    private String lyrics;

    public Singer() {
        Random r = new Random();
        lyrics = String.format("I played a quick game of Random %d", r.nextInt());
    }

    public void sing() {
        System.out.println(lyrics);
    }
}
