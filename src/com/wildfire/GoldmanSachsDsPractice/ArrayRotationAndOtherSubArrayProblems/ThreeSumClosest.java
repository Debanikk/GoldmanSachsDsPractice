package com.wildfire.GoldmanSachsDsPractice.ArrayRotationAndOtherSubArrayProblems;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4 };
        int target = 1;
        int result = getThreeSumClosest(nums, target);
        System.out.println(result);
    }

    public static int getThreeSumClosest(int[] nums, int target) {
        int result = 0;
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == target) {
                    return sum;
                }
                else if(sum < target) {
                    left++;
                }
                else {
                    right--;
                }
                int diff = Math.abs(sum - target);
                if(diff < minDiff) {
                    minDiff = diff;
                    result = sum;
                }
            }
        }
        return result;
    }
}
