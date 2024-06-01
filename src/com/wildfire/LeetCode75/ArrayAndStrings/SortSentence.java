package com.wildfire.LeetCode75.ArrayAndStrings;

import java.util.HashMap;
import java.util.Map;

public class SortSentence {
    public static void main(String[] args) {
        String s = "is2 sentence4 This1 a3";
        System.out.println(" actual String is - " + sortSentence(s));
    }

    private static String sortSentence(String s) {
        Map<Integer, String> indexWordMap = new HashMap<>();
        for(String word : s.split(" ")) {
            int lastIndex = word.length() - 1;

            // get the word and index separately
            int index = word.charAt(lastIndex) - '0';
            String actualWord = word.substring(0, lastIndex);
            indexWordMap.put(index, actualWord);
        }

        //build actual word
        StringBuilder actualString = new StringBuilder();
        for(Map.Entry<Integer, String> indexWord : indexWordMap.entrySet()) {
            actualString.append(indexWord.getValue());
            actualString.append(" ");
        }

        return actualString.toString().trim();
    }
}
