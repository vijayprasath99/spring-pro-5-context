package com.vj.prospring5.application.javaconfiguration;

public class HelloWorldProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Howdie Partner!";
    }
}
