package com.wildfire.LeetCode75.TwoPointers;

public class TrappingRainWaterProblem {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int result = trapBruteForceUsingDP(height);
        int optimumResult = trapWaterTwoPointer(height);
        System.out.println("Optimum result is - " + optimumResult);

        System.out.println("Rain water amount that can be trapped - " + result);
    }

    private static int trapBruteForceUsingDP(int[] height) {
        int len = height.length;
        if(len < 3)
            return 0;

        int[] left = new int[len];
        for(int i = 0; i < len; i++) {
            left[i] = i == 0 ? height[i] : Math.max(left[i-1], height[i]);
        }

        int[] right = new int[len];
        for(int i = len - 1; i >= 0 ; i--) {
            right[i] = i == len - 1 ? height[i] : Math.max(right[i+1], height[i]);
        }

        int sum = 0;
        for(int i = 0; i < len; i++) {
            sum += Math.min(right[i], left[i]) - height[i];
        }

        return sum;
    }

    private static int trapWaterTwoPointer(int[] height) {
        int max = 0, len = height.length;
        // Finding the tallest point in the array and saving its array index
        for(int i = 0; i < len; i++) {
            if(height[max] < height[i]) {
                max = i;
            }
        }
        int sum = 0;
        int leftMax = 0;
        for(int i = 0; i < max; i++) {
            if(height[leftMax] < height[i]) {
                leftMax = i;
            }
            sum += Math.min(height[leftMax], height[max]) - height[i];
        }
        int rightMax = len - 1;
        for(int i = len - 1; i > max; i--) {
            if(height[rightMax] < height[i]) {
                rightMax = i;
            }
            sum += Math.min(height[max], height[rightMax]) - height[i];
        }
        return sum;
    }
}
