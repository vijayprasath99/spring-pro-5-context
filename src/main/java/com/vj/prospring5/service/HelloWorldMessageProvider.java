package com.vj.prospring5.service;

import org.springframework.stereotype.Service;

public class HelloWorldMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello World2";
    }
}
