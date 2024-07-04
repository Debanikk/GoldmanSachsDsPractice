package com.wildfire.LeetCode75.dynamicProgramming;

public class StringToStringConvertMinimumEditDistance {
    public static void main(String[] args) {
        String word1 = "abcdef";
        String word2 = "azcde";
        System.out.println("Minimum number of steps required is - " + minDistance(word1, word2));
    }

    private static int minDistance(String word1, String word2) {
        if(word1 == null && word2 == null)
            return 0;

        final int len1 = word1.length();
        final int len2 = word2.length();

        // initialize a dynamic 2d array to store all previously calculated results
        int[][] costDP = new int[len1 + 1][len2+1];
        //initialize the dp matrix array
        for(int i = 1; i<= len1; ++i) costDP[i][0] = i;
        for(int j = 1; j<= len2; ++j) costDP[0][j] = j;

        // start generating the cost matrix

        for(int i = 1; i<= len1; ++i) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // copy cost from top left - Diagonal value
                    costDP[i][j] = costDP[i - 1][j - 1];
                } else {
                    int topLeft = costDP[i - 1][j - 1];
                    int top = costDP[i - 1][j];
                    int left = costDP[i][j - 1];
                    costDP[i][j] = Math.min(topLeft, Math.min(top, left)) + 1;
                }
            }
        }
        System.out.println();
        return costDP[len1][len2];
    }

}
