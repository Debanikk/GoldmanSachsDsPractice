package com.wildfire.GoldmanSachsDsPractice.SmallestNumber;

public class SecondSmallestSolution {
    public static void main(String[] args){
        int[] a = { 0 };
        int[] b = { 5, 0, 7, 3, 2 };

        boolean result = true;
        result &= secondSmallest(a) == 0;
        result &= secondSmallest(b) == 2;

        if (result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public static int secondSmallest(int[] x) {
        // Your code
        if(x.length < 1) {
            return 0;
        }
        if(x.length < 2) {
            return x[0];
        }
        int min = Integer.MAX_VALUE, min1 = Integer.MAX_VALUE;
        for(int i = 0; i < x.length; i++) {
            if(x[i] <= min) {
                min1 = min;
                min = x[i];
            }
            else if(x[i] < min1) {
                min1 = x[i];
            }
        }
        return min1;
    }
}
