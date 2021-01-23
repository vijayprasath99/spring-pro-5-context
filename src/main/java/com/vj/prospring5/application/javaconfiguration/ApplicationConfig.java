package com.vj.prospring5.application.javaconfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({XmlConfiguration.class})
public class ApplicationConfig {

    @Autowired
    MessageProvider provider;

    @Bean
    public MessageRenderer renderer() {
        StandardOutRenderer s = new StandardOutRenderer();
        s.setMessageProvider(provider);
        return s;
    }
}