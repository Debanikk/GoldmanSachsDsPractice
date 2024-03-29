package com.wildfire.GoldmanSachsDsPractice.ArrayRotationAndOtherSubArrayProblems;

public class MaxSumInContiguousSubArray {
    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3 };
        int res = getMaxSumFromArray(arr);
        System.out.println("Max sum is: " + res);
    }

    public static int getMaxSumFromArray(int[] arr) {
        int len = arr.length;
        if(len < 1)
            return 0;
        if(len < 2)
            return arr[0];

        int max_ending_here = 0, max_so_far = Integer.MIN_VALUE, start = 0, end = 0, s = 0;
        for(int i = 0; i < len; i++) {
            max_ending_here += arr[i];
            if(max_so_far < max_ending_here) {
                max_so_far = max_ending_here;
                start = s;
                end = i;
            }

            if(max_ending_here < 0) {
                max_ending_here = 0;
                s = i + 1;
            }
        }
        System.out.println("Start point is : " + start);
        System.out.println("End is: " + end);
        return max_so_far;
    }
}
