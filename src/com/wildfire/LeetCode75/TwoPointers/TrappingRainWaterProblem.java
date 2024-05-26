package com.wildfire.LeetCode75.TwoPointers;

public class TrappingRainWaterProblem {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        //int[] height = {0,1,2,3,4,5,6,7,8,9,10,11,10,11,10,9,8,7,6,5,4,3,2,1,0};
        //int result = trapBruteForceUsingDP(height);
        int optimumResult = trapWaterTwoPointer(height);
        System.out.println("Total harvested water in Optimum way is - " + optimumResult + " unit");

        //System.out.println("Rain water amount that can be trapped - " + result);
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

        // Find the water that can be stored on the left side of the max column in array
        int sum = 0;
        int leftMax = 0;
        for(int i = 0; i < max; i++) {
            if(height[leftMax] < height[i]) {
                leftMax = i;
            }
            sum += Math.min(height[leftMax], height[max]) - height[i];
        }

        // Find the water that can be stored on the left side of the max column in array
        int rightMax = len - 1;
        for(int i = len - 1; i > max; i--) {
            if(height[rightMax] < height[i]) {
                rightMax = i;
            }
            sum += Math.min(height[max], height[rightMax]) - height[i];
        }
        // return total water harvested
        return sum;
    }
}
