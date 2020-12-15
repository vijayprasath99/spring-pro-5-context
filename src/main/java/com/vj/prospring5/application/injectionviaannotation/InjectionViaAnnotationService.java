package com.vj.prospring5.application.injectionviaannotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.stream.IntStream;

@Component("InjectionViaAnnotationService")
public class InjectionViaAnnotationService {

    @Value("#{map}")
    Map<String, String> set;

    public void print() {
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, 100).forEach(i -> sb.append("-"));
        System.out.println(sb.toString());
        System.out.println(this.set.toString());
    }
}
