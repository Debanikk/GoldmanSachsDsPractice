package com.wildfire.GoldmanSachsDsPractice.dynamicProgramming;

public class HouseRobber {
    public static void main(String[] args) {
        //int[] wealth = {2,7,3,1,4,2,1,8};
        int[] wealth = {1,1};
        System.out.println("Maximum wealth that can be robbed is - " + getRobbedAmountSpaceOptimized(wealth));
    }

    private static int getRobbedAmount(int[] houseWealths) {
        if(houseWealths.length < 2)
            return houseWealths[0];
        int[] wealthDynamicResults = new int[houseWealths.length];
        wealthDynamicResults[0] = houseWealths[0];
        wealthDynamicResults[1] = Math.max(houseWealths[0], houseWealths[1]);

        for(int i = 2; i < houseWealths.length; i++) {
            wealthDynamicResults[i] = Math.max(wealthDynamicResults[i-2] + houseWealths[i], wealthDynamicResults[i-1]);
        }
        return wealthDynamicResults[houseWealths.length - 1];
    }

    public static int getRobbedAmountSpaceOptimized(int[] nums) {
        if(nums.length < 2)
            return nums[0];

        int[] dResult = new int[3];
        dResult[0] = nums[0];
        dResult[1] = Math.max(nums[0], nums[1]);
        if(nums.length > 2) {
            for(int i = 2; i < nums.length; i++) {
                dResult[2] = Math.max(dResult[0] + nums[i], dResult[1]);
                dResult[0] = dResult[1];
                dResult[1] = dResult[2];
            }
        }
        else {
            return dResult[1];
        }

        return dResult[2];
    }
}
