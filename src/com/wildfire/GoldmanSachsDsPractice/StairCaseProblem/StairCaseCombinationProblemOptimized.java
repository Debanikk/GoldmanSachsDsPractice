package com.wildfire.GoldmanSachsDsPractice.StairCaseProblem;

import java.util.Arrays;

public class StairCaseCombinationProblemOptimized {
    public static void main(String[] args) {
        System.out.println("Test results are fine for combination - " + doTestsPass());
    }

    public static boolean doTestsPass()
    {
        return findStep(3) == 4
                && findStep(4) == 7;
    }

    static int findStep(int n){
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return findStepHelper(n, dp);
    }

    static int findStepHelper(int n, int[] dp){
        //base case - edge case
        if(n == 0)
            return 1;
        else if(n < 0)
            return 0;

        // if sub problems are already calculated then return the same
        if(dp[n] != -1){
            return dp[n];
        }

        // store sub problem results in vector
        return dp[n] = findStepHelper(n-3, dp) + findStepHelper(n-2, dp) + findStepHelper(n-1, dp);
    }
}
