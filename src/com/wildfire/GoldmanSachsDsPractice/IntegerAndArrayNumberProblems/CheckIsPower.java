package com.wildfire.GoldmanSachsDsPractice.IntegerAndArrayNumberProblems;

public class CheckIsPower {
    public static void main(String[] args) {
        System.out.println(isPower(10, 1) ? 1 : 0);
        System.out.println(isPower(1, 20) ? 1 : 0);
        System.out.println(isPower(2, 128) ? 1 : 0);

        System.out.println(isPowerOptimised(27, 729));
    }

    // returns true if y is a power of x
    // Time complexity - O(logx^Y)
    static Boolean isPower(int x, int y) {
        if(x == 1)
            return  (y == 1);

        int pow = 1;
        while(pow < y)
            pow = pow * x;

        return (pow == y);
    }

    static Boolean isPowerOptimised(int x, int y){
        // logarithmic function to calculate value
        int res1 = (int)Math.log(y) / (int) Math.log(x);
        //This is double
        double res2 = Math.log(y) / Math.log(x);
        // return after comparing to the result
        // of result1 and result2 if both are equal or not
        return (res1 == res2);
    }
}
