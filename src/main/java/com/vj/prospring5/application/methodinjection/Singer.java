package com.vj.prospring5.application.methodinjection;

import java.util.Random;

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
