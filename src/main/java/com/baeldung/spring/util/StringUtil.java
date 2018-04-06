package com.baeldung.spring.util;


public class StringUtil {

    public static String StringFormat(String originalStr, String... strings) {
        try {

            int count = strings.length;

            for (int i = 0; i < count; i++) {

                originalStr = originalStr.replace("{" + i + "}", strings[i]);

            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return originalStr;
    }
}