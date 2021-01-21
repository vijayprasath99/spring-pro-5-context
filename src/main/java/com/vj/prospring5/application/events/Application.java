package com.vj.prospring5.application.events;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import static com.vj.prospring5.util.PrintHelper.delimitLine;

public class Application implements ApplicationContextAware {

    ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @ComponentScan("com.vj.prospring5.application.events")
    public static class ApplicationConfiguration {
        @Bean
        public Application application() {
            return new Application();
        }

        @Bean
        public MessageListener massageListener() {
            return new MessageListener();
        }
    }

    public void publish(String msg) {
        this.applicationContext.publishEvent(new MessageEvent(this, msg));
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        Application app = ctx.getBean(Application.class);

        delimitLine();
        app.publish("Howdie partner!");
        app.publish("Greetings from the application...");
        delimitLine();

        ctx.close();
    }
}
