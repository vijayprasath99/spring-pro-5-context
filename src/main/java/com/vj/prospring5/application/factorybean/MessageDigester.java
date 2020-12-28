package com.vj.prospring5.application.factorybean;

import org.springframework.beans.factory.BeanNameAware;

import java.security.MessageDigest;

public class MessageDigester implements BeanNameAware {
    private String beanName;

    private MessageDigest messageDigest1;
    private MessageDigest messageDigest2;

    public void setMessageDigest1(MessageDigest messageDigest1) {
        this.messageDigest1 = messageDigest1;
    }

    public void setMessageDigest2(MessageDigest messageDigest2) {
        this.messageDigest2 = messageDigest2;
    }
    
    public void digest(String str) {
        System.out.printf("[%s] Using Digest 1%n", beanName);
        digest(messageDigest1, str);
        
        System.out.printf("[%s] Using Digest 2%n", beanName);
        digest(messageDigest2, str);
    }
    
    private void digest(MessageDigest messageDigest , String msg) {
        System.out.printf("[%s] Using Algorithm: %s%n", beanName, messageDigest.getAlgorithm());
        messageDigest.reset();

        byte[] input = msg.getBytes();
        byte[] output = messageDigest.digest(input);

        System.out.println(output);
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }
}
