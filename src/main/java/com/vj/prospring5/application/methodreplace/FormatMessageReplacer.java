package com.vj.prospring5.application.methodreplace;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

public class FormatMessageReplacer implements MethodReplacer {

    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        if (isFormatMessageMethod(method)) {
            return String.format("<repl>%s</repl>", args[0]);
        } else {
            return method.invoke(args);
        }
    }

    private boolean isFormatMessageMethod(Method method) {
        boolean isSingleParameter = method.getParameterCount() == 1;
        boolean hasSingleParameterString = isSingleParameter && method.getParameterTypes()[0] == String.class;
        String formatMessageMethodName = "formatMessage";
        boolean isCorrectMethodName = method.getName().equals(formatMessageMethodName);
        boolean returnsString = method.getReturnType() == String.class;

        return hasSingleParameterString && isCorrectMethodName && returnsString;

    }
}
