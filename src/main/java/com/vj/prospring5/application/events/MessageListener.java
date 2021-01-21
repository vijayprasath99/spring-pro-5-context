package com.vj.prospring5.application.events;

import org.springframework.context.ApplicationListener;

public class MessageListener implements ApplicationListener<MessageEvent> {

    @Override
    public void onApplicationEvent(MessageEvent event) {
        System.out.println("Received:: " + event.getMsg());
    }
}
