package com.wildfire.LeetCode75.TwoPointers;

import java.util.Arrays;

public class SortedSquares {
    public static void main(String[] args) {
        int[] arr = {-7,-3,2,3,11};
        System.out.println("Squares of the sorted array is - " + Arrays.toString(getSortedSquares(arr)));
    }

    private static int[] getSortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        // square all elements in the input array
        for(int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }

        int head = 0, tail = nums.length - 1;

        //fill result array
        for(int pos = nums.length - 1; pos >= 0; pos--) {
            if(nums[head] > nums[tail]) {
                result[pos] = nums[head];
                head++;
            }
            else {
                result[pos] = nums[tail];
                tail--;
            }
        }
        return result;
    }
}
