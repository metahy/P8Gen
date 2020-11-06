package com.tools.gen.utils;

import java.util.List;

public class NoteUtils {
    public static String singleLine(String line, int indent) {
        return Indents.with(indent) + "// " + line + "\n";
    }

    public static String multiLine(List<String> lines, int indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(Indents.with(indent));
        sb.append("/**\n");
        if (lines == null || lines.isEmpty()) {
            sb.append(Indents.with(indent)).append(" * \n");
        } else {
            lines.forEach(s -> sb.append(Indents.with(indent)).append(" * ").append(s).append("\n"));
        }
        sb.append(Indents.with(indent)).append(" */\n");
        return sb.toString();
    }
}
