package com.vj.prospring5.application.factorybean;

import java.security.MessageDigest;

public class MessageDigester {
    private MessageDigest messageDigest1;
    private MessageDigest messageDigest2;

    public void setMessageDigest1(MessageDigest messageDigest1) {
        this.messageDigest1 = messageDigest1;
    }

    public void setMessageDigest2(MessageDigest messageDigest2) {
        this.messageDigest2 = messageDigest2;
    }
    
    public void digest(String str) {
        System.out.println("Using Digest 1");
        digest(messageDigest1, str);
        
        System.out.println("Using Digest 2");
        digest(messageDigest2, str);
    }
    
    private void digest(MessageDigest messageDigest , String msg) {
        System.out.println("Using Algorithm: " + messageDigest.getAlgorithm());
        messageDigest.reset();

        byte[] input = msg.getBytes();
        byte[] output = messageDigest.digest(input);

        System.out.println(output);
    }
}
