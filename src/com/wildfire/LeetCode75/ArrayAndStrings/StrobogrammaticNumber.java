package com.wildfire.LeetCode75.ArrayAndStrings;

import java.util.ArrayList;

/***************************
 * For the given length n, find all n-length Strobogrammatic numbers.
 *
 * Strobogrammatic Number is a number whose numeral is rotationally symmetric so that it appears the same when rotated 180 degrees.
 * In other words, Strobogrammatic Number appears the same right-side up and upside down.
 *
 * 0 after 180° rotation : (0 → 0)
 * 1 after 180° rotation : (1 → 1)
 * 8 after 180° rotation : (8 → 8)
 * 6 after 180° rotation : (6 → 9)
 * 9 after 180° rotation : (9 → 6)
 *
 * Input : n = 2
 * Output : 88  11  96  69
 *
 * Input : n = 4
 * Output : 8008 1001 9006 6009 8888 1881 9886 6889 8118 1111
 *         9116 6119 8968 1961 9966 6969 8698 1691 9696 6699
 *
 *
 * *************************/
public class StrobogrammaticNumber {
    // definition function
    static ArrayList<String> numdef(int n, int length) {
        ArrayList<String> result = new ArrayList<String>();
        if (n == 0){
            result.add("");
            return result;
        }
        if (n == 1) {
            result.add("1");
            result.add("0");
            result.add("8");
            return result;
        }

        ArrayList<String> middles = numdef(n - 2, length);

        for (String middle : middles) {
            if (n != length)
                result.add("0" + middle + "0");

            result.add("8" + middle + "8");
            result.add("1" + middle + "1");
            result.add("9" + middle + "6");
            result.add("6" + middle + "9");
        }

        return result;
    }

    // strobogrammatic function
    static ArrayList<String> strobogrammatic_num(int n) {
        ArrayList<String> result = numdef(n, n);
        return result;
    }

    // Driver Code
    public static void main(String[] args) {
        // Print all Strobogrammatic numbers for n = 2
        for (String num : strobogrammatic_num(2))
            System.out.print(num + " ");
    }
}
