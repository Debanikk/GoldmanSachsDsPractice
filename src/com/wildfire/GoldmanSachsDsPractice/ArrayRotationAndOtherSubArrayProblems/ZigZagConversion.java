package com.wildfire.GoldmanSachsDsPractice.ArrayRotationAndOtherSubArrayProblems;

public class ZigZagConversion {
    public static void main(String[] args) {
        String baseString = "PAYPALISHIRING";
        int numberOfRowsForConversion = 4;
        String result = convert(baseString, numberOfRowsForConversion);
        System.out.println(String.format("The converted String is - %s", result));
        if(result.equals("PINALSIGYAHRPI")) {
            System.out.println("Test Case passed");
        }
        else {
            System.out.println("Test case failed");
        }
    }

    public static String convert(String s, int numRows) {
        // Check the edge case scenarios and vanilla when string length is equals to the number of rows for conversion
        if(numRows <= 1 || s.length() <= numRows)
            return s;

        // Next step is to create a stringBuilder array where we would need to add each string for each row basis
        StringBuilder[] sbArr = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++) {
            sbArr[i] = new StringBuilder();
        }

        // define variables
        int index = 0;
        char[] cArr = s.toCharArray();
        int len = cArr.length;

        // Handle the zigzag pattern in a loop - Complete 1 set go down and 1 set go up before 0th row
        while(index < len) {
            // pattern 1 - Go down column wise
            for(int j = 0; j < numRows && index < len; j++) {
                sbArr[j].append(cArr[index++]);
            }

            //pattern 2 - go up in diagonal way and stop before 0th row
            for(int j = numRows - 2; j > 0 && index < len; j--) {
                sbArr[j].append(cArr[index++]);
            }
        }

        // combine all the StringBuilders from each row in the sbArr and build teh final string
        StringBuilder result = sbArr[0];
        for(int i = 1; i < numRows; i++) {
            result.append(sbArr[i].toString());
        }

        //return final result string
        return result.toString();
    }
}
