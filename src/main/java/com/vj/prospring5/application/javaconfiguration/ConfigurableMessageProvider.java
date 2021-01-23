package com.vj.prospring5.application.javaconfiguration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("provider")
public class ConfigurableMessageProvider implements MessageProvider {
    String msg;

    public ConfigurableMessageProvider(@Value("Bean from Component Scan") String msg) {
        this.msg = msg;
    }

    @Override
    public String getMessage() {
        return msg;
    }
}
