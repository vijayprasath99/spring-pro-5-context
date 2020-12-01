package com.vj.prospring5.configuration;

import com.vj.prospring5.service.HelloWorldMessageProvider;
import com.vj.prospring5.service.MessageProvider;
import com.vj.prospring5.service.MessageRenderer;
import com.vj.prospring5.service.StandardOutMessageRenderer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@ImportResource("classpath:application-context.xml")
@ComponentScan("com.vj.prospring5")
@Configuration
public class ApplicationConfiguration {
    
//    @Bean
//    public MessageProvider provider() {
//        return new HelloWorldMessageProvider();
//    }
//    
//    @Bean
//    public MessageRenderer renderer() {
//        return new StandardOutMessageRenderer(provider());
//    }
}
