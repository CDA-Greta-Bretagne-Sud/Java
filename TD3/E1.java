package com.stevancorre;

import java.util.Arrays;

final class E1 {
    public static void main(final String[] args) {
        final String sentence = "le le chat boit   du boit  lait";
        System.out.println(Arrays.toString(listWords(sentence)));
    }

    private static String[] listWords(final String sentence) {
        return Arrays
                .stream(sentence.split(" +"))
                .distinct()
                .toArray(String[]::new);
    }
}
