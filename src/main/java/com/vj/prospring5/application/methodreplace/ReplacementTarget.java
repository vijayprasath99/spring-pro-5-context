package com.vj.prospring5.application.methodreplace;

public class ReplacementTarget {
    public String formatMessage(String msg) {
        return "<orig>" + msg + "</orig>";
    }

    public String formatMessage(StringBuilder obj) {
        return String.format("<sb>%s</sb>", obj.toString());
    }

    public String formatMessage(Object obj) {
        return String.format("<obj>%s</obj>", obj.toString());
    }
}
