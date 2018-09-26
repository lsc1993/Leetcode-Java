package com.ls.leetcode.util;

public class Log {

    public static void logLn(String message) {
        System.out.println(message);
    }

    public static void log(String message) {
        System.out.print(message);
    }

    public static <T> void printArray(T[] array) {
        if (array == null) {
            System.out.println("array is null!");
        }
        StringBuilder builder = new StringBuilder();
        builder.append("print array: ");
        for (T t : array) {
            builder.append(String.valueOf(t)).append(" ");
        }

        builder.append("length:").append(array.length);
        System.out.println(builder.toString());
    }
}
