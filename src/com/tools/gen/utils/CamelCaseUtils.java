package com.tools.gen.utils;

public class CamelCaseUtils {

    public static String toCamelCase(String originName) {
        if (StringUtils.isBlank(originName)) {
            return "";
        }

        String spaceStr = originName.replaceAll("_", " ").replaceAll("-", " ").replaceAll("\\.", " ").replaceAll(",", " ").replaceAll("\t", " ").trim();

        StringBuffer sb = null;
        if (!spaceStr.isEmpty()) {
            String[] split = spaceStr.split(" ");
            sb = new StringBuffer();
            for (String s : split) {
                sb.append(s.substring(0, 1).toUpperCase()).append(s.substring(1).toLowerCase());
            }
        }

        return sb == null ? "" : sb.substring(0, 1).toLowerCase() + sb.substring(1);
    }
}
