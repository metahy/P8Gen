package com.tools.gen.utils;

/**
 * @author hiram 2020年11月06日 00:47
 */
public class Indents {

    public static final String METHOD_CONTENT_INDENT = "    ";

    public static String method(String line, int indent) {
        StringBuilder sb = new StringBuilder("\n");
        for (int i = 0; i < indent + 1; i++) {
            sb.append(METHOD_CONTENT_INDENT);
        }
        return sb.append(line).toString();
    }

    public static String with(int indent) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indent; i++) {
            sb.append(METHOD_CONTENT_INDENT);
        }
        return sb.toString();
    }
}
