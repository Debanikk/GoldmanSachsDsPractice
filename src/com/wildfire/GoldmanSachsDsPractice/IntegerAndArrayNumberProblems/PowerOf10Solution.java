package com.wildfire.GoldmanSachsDsPractice.IntegerAndArrayNumberProblems;

public class PowerOf10Solution {
    public static void main(String[] args) {
        doTestsPass();
    }

    public static boolean doTestsPass()
    {
        int[] isPowerList = {100};
        int[] isNotPowerList = {3};

        for(int i : isPowerList)
        {
            if(!isPowerOf10(i))
            {
                System.out.println("Test failed for: " + i);
                return false;
            }
        }

        for(int i : isNotPowerList)
        {
            if(isPowerOf10(i))
            {
                System.out.println("Test failed for: " + i);
                return false;
            }
        }

        System.out.println("All tested passed");
        return true;
    };

    private static boolean isPowerOf10(int num){
        if(num < 1)
            return false;

        while( num > 1){
            if(num%10 !=0){
                return false;
            }
            num = num/10;
        }
        return true;
    }

}
