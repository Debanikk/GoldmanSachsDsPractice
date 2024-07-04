package com.wildfire.LeetCode75.dynamicProgramming;

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
        // Create a matrix for storing step by step result
        // where each cell in matrix will show the no of coins
        // required to achieve total from X axis by using no of
        // denominations present in Y axis
        int[][] dp = new int[amount+1][len+1];

        // fill up first row - which shows how many coins
        // required to achieve a target amount
        for(int i = 0; i <= amount; i++) {
            dp[i][0] = i;
        }

        // fill up first column - which shows using how many
        // denominations the 0 amount can be achieved -
        // which is technically 0 for what ever number of
        // denomination we have
        for(int j = 0; j<= len; j++) {
            dp[0][j] = 0;
        }

        // start filling up the matrix on the basis of last
        // calculated values and comparing them and picking
        // the minimum always. We start by finding the no of
        // coins that are required to get the next amount.
        // example - how many coins required to get amount
        // 1 with 0 -> N denominations, then gradually
        // increase the amount and calculate the next amount
        // here amount is the value of i in each step. i = 11
        // means 11 is the amount
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
        Set<Integer> coinSet = new HashSet<>();
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
