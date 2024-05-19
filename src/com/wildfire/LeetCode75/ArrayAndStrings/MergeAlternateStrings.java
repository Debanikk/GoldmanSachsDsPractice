package com.wildfire.LeetCode75.ArrayAndStrings;

public class MergeAlternateStrings {
    public static void main(String[] args) {
        String result = mergeAlternately("ab", "pqrs");
        System.out.println(result);
    }

    public static String mergeAlternately(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int i=0;
        StringBuilder res = new StringBuilder();

        while(i<n && i<m) {
            res.append(word1.charAt(i));
            res.append(word2.charAt(i));
            i=i+1;
        }

        if(i<n) {
            res.append(word1, i, n);
        }
        if(i<m) {
            res.append(word2, i, m);
        }

        return res.toString();
    }
}
