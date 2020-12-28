package com.vj.prospring5.application.factorybean;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MessageDigestFactory {
    private String algorithm = "MD5";

    public MessageDigest createInstance() throws NoSuchAlgorithmException {
        return MessageDigest.getInstance(algorithm);
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }
}
