package com.wildfire.LeetCode75.ArrayAndStrings;

import java.util.Arrays;

public class ProductExceptSelf {
    public static void main(String[] args) {
        int[] nums = {-1,1,0,-3,3};
        System.out.println("The result array where product of array elements without self is - " + Arrays.toString(getProductExceptSelf(nums)));
    }

    private static int[] getProductExceptSelf(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];

        left[0] = 1;
        for(int i = 1; i < len; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        right[len-1] = 1;
        for(int i = len - 2; i > -1; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        int[] res = new int[len];
        for(int i = 0; i < len; i++) {
            res[i] = left[i] * right[i];
        }

        return res;
    }

    // another approach with same time complexity but better execution time
    public int[] productExceptSelf(int[] nums) {

        int[] ans = new int[nums.length];

        //prefix array
        int prefix = 1;
        for(int i = 0; i < nums.length; i++) {
            ans[i] = prefix;
            prefix  *= nums[i];
        }

        int postfix = 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            ans[i] *=postfix;
            postfix *=nums[i];
        }
        return ans;
    }
}
