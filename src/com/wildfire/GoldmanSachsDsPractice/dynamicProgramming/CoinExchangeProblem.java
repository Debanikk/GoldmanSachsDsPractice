package com.wildfire.GoldmanSachsDsPractice.dynamicProgramming;

import java.util.HashSet;
import java.util.Set;

public class CoinExchangeProblem {
    public static void main(String[] args) {
        int[] arr = {1, 5, 6, 9};
        int sum = 11;

        int result = getMinCoinsRequired(arr, sum);
        System.out.println(String.format("The result is - %s", result));
    }

    private static int getMinCoinsRequired(int[] arr, int amount) {
        int len = arr.length;
        Set<Integer> coinSet = new HashSet<>();

        int[][] dp = new int[amount+1][len+1];

        for(int i = 0; i <= amount; i++) {
            dp[i][0] = i;
        }

        for(int j = 0; j<= len; j++) {
            dp[0][j] = 0;
        }

        for(int j = 1; j <= len; j++) {
            for(int i = 1; i <= amount; i++) {
                if(arr[j-1] <= i  && dp[i][j-1] > dp[i - arr[j-1]][j] + 1) {
                    dp[i][j] = dp[i - arr[j-1]][j] + 1;
                }
                else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }

        // BACK TRACKING SOLUTION - code to track the coins used for exchange
        int i = amount;
        int j = len;
        while(i > 0 && j > 0) {
            if(dp[i][j] == dp[i][j-1]) {
                j = j-1;
            }
            else{
                coinSet.add(arr[j-1]);
                System.out.println(String.format("Coin used i - %s", arr[j-1]));
                i = i - arr[j-1];
            }
        }
        while(i > 0) {
            System.out.println(String.format("Coin used i - %s", arr[0]));
            coinSet.add(arr[0]);
             i = i - 1;
        }

        System.out.println(coinSet);
        return dp[amount][len];
    }
}
