package com.wildfire.LeetCode75.SlowAndFastPointer;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static void main(String[] args) {
        int num = 61;
        System.out.println("The number " + num + " is happy - " + isHappy(num));
    }

    private static boolean isHappy(int num) {
        Set<Integer> usedIntegers = new HashSet<>();
        while(true) {
            int sum = 0;
            /// finding sum of squares
            while(num != 0) {
                sum += Math.pow(num % 10, 2.0);
                num /= 10;
            }
            if(sum == 1)
                return true;

            num = sum;
            if(usedIntegers.contains(num))
                return false;
            usedIntegers.add(num);
        }
    }
}
