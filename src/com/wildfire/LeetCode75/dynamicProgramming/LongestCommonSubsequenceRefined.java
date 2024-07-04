package com.wildfire.LeetCode75.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonSubsequenceRefined {
    public static void main(String[] args) {
        String s1 = "ABCABBA";
        String s2 = "CBABACA";

        System.out.println("Length of LCS is - " + getLcsLength(s1, s2));
        System.out.println("LCS is - " + getLcs(s1, s2));
    }

    private static int getLcsLength(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }

    private static String getLcs(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        // Fill the dp table
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        // Trace back to find the LCS
        int i = s1.length();
        int j = s2.length();
        List<Character> lcs = new ArrayList<>();

        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcs.add(s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i][j -1] >= dp[i - 1][j]) {
                j--;
            } else {
                i--;
            }
        }

        // Reverse the list to get the correct order
        StringBuilder lcsStr = new StringBuilder(lcs.size());
        for (int k = lcs.size() - 1; k >= 0; k--) {
            lcsStr.append(lcs.get(k));
        }

        return lcsStr.toString();
    }
}
