package com.wildfire.GoldmanSachsDsPractice.IntegerAndArrayNumberProblems;

public class ArmstrongNumber {
    public static void main(String[] args) {
        if(isArmstrong(371))
            System.out.println("Test Passed");
        else
            System.out.println("Test Failed");
    }

    static Boolean isArmstrong(int x){
        int digitCount = Order(x);
        int temp = x;
        int sum = 0;
        while(temp != 0){
            int remainder = temp % 10;
            sum = sum + power(remainder, digitCount);
            temp = temp/10;
        }
        return (sum == x);
    }

    static int Order(int x){
        int n = 0;
        while(x!=0){
            n++;
            x = x/10;
        }
        return n;
    }

    // Calculate x raised to the power of y
    // Recursively call power function for odd and even count of y
    static int power(int x, long y){
        if(y == 0)
            return 1;
        if(y % 2 == 0)
            return power(x, y/2) * power(x, y/2);
        return x * power(x, y/2) * power(x, y/2);
    }
}
