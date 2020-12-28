package com.vj.prospring5.application.aliasbyannotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Award {

    @AliasFor("prize")
    String[] value() default {};

    @AliasFor("value")
    String[] prize() default {};
}
