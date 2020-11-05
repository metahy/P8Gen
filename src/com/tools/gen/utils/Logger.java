package com.tools.gen.utils;

public class Logger {

    public static void info(Object obj) {
        System.out.println("[INFO] " + obj.toString());
    }
    public static void warn(Object obj) {
        System.err.println("[WARN] " + obj.toString());
    }
}
