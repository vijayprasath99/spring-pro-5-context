package com.vj.prospring5.application.javaconfiguration;

public class StandardOutRenderer implements MessageRenderer {
    MessageProvider messageProvider;

    public MessageProvider getMessageProvider() {
        return messageProvider;
    }

    public void setMessageProvider(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }

    @Override
    public void render() {
        System.out.println(this.messageProvider.getMessage());
    }
}
