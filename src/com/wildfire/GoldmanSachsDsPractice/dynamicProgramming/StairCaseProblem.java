package com.wildfire.GoldmanSachsDsPractice.dynamicProgramming;

public class StairCaseProblem {
    public static void main(String[] args) {
        int steps = 4;
        System.out.println("The number of ways " + steps + " can be climbed is - " + getRequiredNumberOfSteps(steps));
    }

    private static int getRequiredNumberOfSteps(int steps) {
        if(steps == 1)
            return 1;

        int[] dp = new int[steps + 1];
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= steps; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[steps];
    }
}
