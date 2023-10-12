package com.wildfire.GoldmanSachsDsPractice.StringOperations;

/**
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead,
 * the number four is written as IV. Because the one is before the five we subtract it making four.
 * The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * **/

public class RomanConvert {
    public static void main(String[] args) {
        String s = "MCMXCIV"; //LVIII
        if(romanToInt(s) == 1994) {
            System.out.println("Test Passed");
        }
        else {
            System.out.println("Test Failed");
        }

        String s2 = "LVIII";
        if(romanToInt(s2) == 58) {
            System.out.println("Test Passed");
        }
        else {
            System.out.println("Test Failed");
        }
    }

    public static int romanToInt(String s) {
        char[] cArr = s.toCharArray();
        if(cArr.length < 1) {
            return 0;
        }

        int result = 0;
        for(int i = 0; i < cArr.length; ++i) {
            int temp = returnVal(cArr[i]);
            System.out.println("The value of i is - " + i + " and value of temp is: " + temp);

            if(i + 1 < cArr.length) {
                if (temp < returnVal(cArr[i + 1])) {
                    temp = returnVal(cArr[i + 1]) - temp;
                    i = i + 1;
                }
                result = result + temp;
            }
            else {
                result = result + temp;
            }

        }
        System.out.println("The final Value is : " + result);
        return result;
    }

    public static int returnVal(char c) {
        switch(c) {
            case 'M':
                return 1000;
            case 'D':
                return 500;
            case 'C':
                return 100;
            case 'L':
                return 50;
            case 'X':
                return 10;
            case 'V':
                return 5;
            case 'I':
                return 1;
            default:
                return 0;
        }
    }
}
