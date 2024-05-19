package com.wildfire.GoldmanSachsDsPractice.dynamicProgramming;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "ABCABBA";
        String s2 = "CBABACA";

        System.out.println("Length of LCS is - " + getLcs(s1, s2));
    }

    private static int getLcs(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for(int i = 0; i <= s1.length(); i++) {
            for(int j = 0; j <= s2.length(); j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
                else if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        int i = s1.length();
        int j = s2.length();
        String finalString = "";

        while (i >= 1 && j >= 1) {

            if (s1.charAt(i-1) == s2.charAt(j-1)) {
                finalString = s1.charAt(i-1) + finalString;
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        System.out.println("The longest common subsequence is - " + finalString);

        return dp[s1.length()][s2.length()];
    }
}
