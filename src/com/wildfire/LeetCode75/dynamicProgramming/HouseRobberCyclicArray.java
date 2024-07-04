package com.wildfire.LeetCode75.dynamicProgramming;

public class HouseRobberCyclicArray {
    public static void main(String[] args) {
        int[] houseWithMoney = {2,7,3,1,4,2,1,8};
        System.out.println("Maximum wealth that can be robbed is - " + robHouse(houseWithMoney));
    }

    private static int robHouse(int[] money) {
        if(money.length < 2)
            return money[0];

        int houseCount = money.length;
        int[] firstHouseSkip = new int[houseCount - 1];
        int[] firstHousePicked = new int[houseCount - 1];

        for(int i = 0; i < houseCount - 1; i++) {
            firstHousePicked[i] = money[i];
            firstHouseSkip[i] = money[i+1];
        }

        return Math.max(getRobbedAmountSpaceOptimized(firstHousePicked), getRobbedAmountSpaceOptimized(firstHouseSkip));
    }

    private static int getRobbedAmountSpaceOptimized(int[] money) {
        if(money.length == 1)
            return money[0];
        if(money.length < 3)
            return Math.max(money[0], money[1]);

        int[] dResult = new int[3];
        dResult[0] = money[0];
        dResult[1] = Math.max(money[0], money[1]);

        for(int i = 2; i < money.length; i++) {
            dResult[2] = Math.max(dResult[0] + money[i], dResult[1]);
            dResult[0] = dResult[1];
            dResult[1] = dResult[2];
        }
        return dResult[2];
    }
}
