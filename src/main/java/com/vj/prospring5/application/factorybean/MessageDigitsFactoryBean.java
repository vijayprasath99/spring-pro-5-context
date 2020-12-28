package com.vj.prospring5.application.factorybean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import java.security.MessageDigest;

public class MessageDigitsFactoryBean implements FactoryBean<MessageDigest>, InitializingBean {
    private String algorithm = "MD5";

    private MessageDigest messageDigit;
    
    @Override
    public MessageDigest getObject() throws Exception {
        return messageDigit;
    }

    @Override
    public Class<?> getObjectType() {
        return MessageDigest.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.messageDigit = MessageDigest.getInstance(algorithm);
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }
}
