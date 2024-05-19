package com.wildfire.LeetCode75.HashSetAndMap;

import java.util.Arrays;

public class TwoCloseStrings {
    public static void main(String[] args) {
        System.out.println("Strings are close enough = " + closeStrings("cabbba", "abbccc"));
    }

    private static boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length())
            return false;
        if (word1.equals(word2))
            return true;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for(char c: word1.toCharArray()){
            freq1[c - 'a']++;
        }

        for(char c: word2.toCharArray()){
            freq2[c - 'a']++;
        }

        for(int i = 0; i < 26; i++) {
            if((freq1[i] == 0 && freq2[i] != 0) ||
                    (freq2[i] == 0 && freq1[i] != 0)) {
                return false;
            }
        }
        Arrays.sort(freq1);
        Arrays.sort(freq2);
        return Arrays.equals(freq1, freq2);
    }
}
