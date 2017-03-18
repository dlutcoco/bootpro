package com.netposa.bootpro.utils;


public class ConstUtil {

    private static final char[] chars = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
            'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

    private static final int len_kb = 1024;

    private ConstUtil() {
    }

    private static String kbStr;

    static {
        if (kbStr == null) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < len_kb; i++) {
                builder.append(chars[(int) (Math.random() * chars.length)]);
            }
            
            kbStr = builder.toString();
        }
    }
    
    public static String randomKbStr() {
        return randomStr(len_kb);
    }
    
    public static String fixKbStr() {
        return kbStr;
    }
    
    private static String randomStr(int length) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len_kb; i++) {
            builder.append(chars[(int) (Math.random() * chars.length)]);
        }
        
        return builder.toString();
    }
}
