package com.line.ticket.common.util;

import java.util.Random;

public class GeneratorTool {
    /**
     * char[0]-char[9] 为 '0'-'9'
     * char[10]-char[35] 为'a'-'z'
     * char[36]-char[61] 为'A'-'Z'
     */
    private static final int WORD_CHARS_LENGTH = 62;

    private static final int NUM_CHAR_LENGTH = 10;

    private static final char[] WORD_CHARS = new char[WORD_CHARS_LENGTH];

    private static final Random random = new Random();

    static {
        for (int i = 0, j = '0'; i < 10; i++, j++) {
            WORD_CHARS[i] = (char) j;
        }
        for (int i = 0, j = 'a', k = 'A'; i < 26; i++, j++, k++) {
            WORD_CHARS[10 + i] = (char) j;
            WORD_CHARS[36 + i] = (char) k;
        }
    }

    public static Random random() {
        return random;
    }

    private static String randomStr(int len, int length) {
        char[] chars = new char[len];
        for (int i = 0; i < len; i++)
            chars[i] = WORD_CHARS[random().nextInt(length)];
        return new String(chars);
    }

    public static String str(int len) {
        return randomStr(len, WORD_CHARS_LENGTH);
    }

    public static String num(int len) {
        return randomStr(len, NUM_CHAR_LENGTH);
    }
}
