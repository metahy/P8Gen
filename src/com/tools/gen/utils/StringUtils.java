package com.tools.gen.utils;

import java.util.Objects;

public class StringUtils {

    public static boolean isEmpty(String s) {
        return s == null || ("".equals(s));
    }

    public static boolean isBlank(String s) {
        return s == null || ("".equals(s.trim()));
    }

    public static boolean isEqual(String a, String b) {
        return Objects.equals(a, b);
    }
}
