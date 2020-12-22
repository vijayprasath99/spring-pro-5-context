package com.vj.prospring5.util;

import java.util.stream.IntStream;

public class PrintHelper {
    public static void delimitLine() {
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, 100).forEach(i -> sb.append("-"));
        System.out.println(sb.toString());
    }
}
