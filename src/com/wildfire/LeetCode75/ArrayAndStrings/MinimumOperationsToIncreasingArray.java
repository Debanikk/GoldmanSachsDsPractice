package com.wildfire.LeetCode75.ArrayAndStrings;

public class MinimumOperationsToIncreasingArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 6, 5, 4};
        int result = minRemove(nums, nums.length);
        System.out.println("Minimum number of operations required: " + result);
    }

    /// working code
    static int minRemove(int arr[], int n)
    {
        int LIS[] = new int[n];
        int len = 0;

        // Mark all elements of LIS as 1
        for (int i = 0; i < n; i++)
            LIS[i] = 1;

        // Find LIS of array
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && (i - j) <= (arr[i] - arr[j]))
                    LIS[i] = Math.max(LIS[i], LIS[j] + 1);
            }
            len = Math.max(len, LIS[i]);
        }

        // Return min changes for array to strictly
        // increasing
        return n - len;
    }

    static int minOperations(int[] nums) {
        int n = nums.length;
        // dp[i] will hold the minimum operations needed up to index i
        int[] dp = new int[n];

        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1]; // No operation needed
            } else {
                // Calculate the number of operations needed to make nums[i] greater than nums[i-1]
                dp[i] = dp[i - 1] + (nums[i - 1] - nums[i] + 1);
                // Adjust nums[i] to be nums[i-1] + 1
                nums[i] = nums[i - 1] + 1;
            }
        }

        return dp[n - 1];
    }


}
