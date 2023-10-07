package com.wildfire.GoldmanSachsDsPractice.SmallestNumber;

public class Solution {
    public static void main(String[] args){
        boolean result = true;
        result = result && FindMin(new int[]{3,4,5,6,1,2}) == 1;
        result = result && FindMin(new int[]{2,1}) == 1;
        result = result && FindMin(new int[]{1}) == 1;

        try {
            FindMin(null);
            result = false;
        }
        catch(Exception e)
        {
            result = result && true;
        }

        if(result)
        {
            System.out.println("All tests pass");
        }
        else
        {
            System.out.println("There are test failures");
        }
    }

    public static int FindMin(int a[])
    {
        /*
         ** Your code goes here
         */
        if(a.length < 1) {
            return 0;
        }
        int min = a[0];
        for(int i = 0; i < a.length; i++) {
            if(a[i] < min) {
                min = a[i];
            }
        }
        return min;
    }
}
