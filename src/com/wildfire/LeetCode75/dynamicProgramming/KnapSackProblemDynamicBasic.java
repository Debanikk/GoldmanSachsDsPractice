package com.wildfire.LeetCode75.dynamicProgramming;

public class KnapSackProblemDynamicBasic {
    public static void main(String[] args) {
        int knapsackSize = 7;
        int[] weights = {2, 1, 3, 2}, values = {12, 10, 21, 15};
        int result = getMaximumValue(knapsackSize, weights, values);
        System.out.println("Max value is - " + result + "$");
    }

    private static int getMaximumValue(int knapsackSize, int[] weights, int[] values) {
        int items = weights.length;

        int[][] dp = new int[items + 1][knapsackSize + 1];

        //dp matrix fil up
        for(int i = 1; i <= items; i++) {
            for(int j = 1; j <= knapsackSize; j++) {
                if(weights[i-1] <= j && (values[i-1] + dp[i-1][j- weights[i-1]] > dp[i-1][j])) {
                    dp[i][j] = values[i-1] + dp[i-1][j- weights[i-1]];
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        // Backtracking and print of selection
        int i = items;
        int j = knapsackSize;

        while(i > 0 && j > 0) {
            if (dp[i][j] != dp[i - 1][j]) {
                System.out.println("Selected item is - " + i + " and weight of item is - " + weights[i-1] + " and item value is - " + values[i-1] + "$");
                j = j - weights[i - 1];
            }
            i--;
        }

        return dp[items][knapsackSize];
    }
}
