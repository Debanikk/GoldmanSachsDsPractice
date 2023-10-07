package com.wildfire.GoldmanSachsDsPractice.LongestUniformSubstring;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestUniformSubStringSolution {

    private static final Map<String, int[]> testCases = new HashMap<String, int[]>();

    public static void main(String[] args){
        testCases.put("abcdefg", new int[]{1, 4});
        testCases.put("", new int[]{-1, 0});
        testCases.put("10000111", new int[]{1, 4});
        testCases.put("aabbbbbCdAA", new int[]{2, 5});
        testCases.put("aaabcbdeaf", new int[]{0,3});

        boolean pass = true;
        for(Map.Entry<String,int[]> testCase : testCases.entrySet()){
            int[] result = longestUniformSubstring(testCase.getKey());
            pass = pass && (Arrays.equals(result, testCase.getValue()));
        }
        if(pass){
            System.out.println("Pass!");
        } else {
            System.out.println("Failed! ");
        }
    }

    static int[] longestUniformSubstring(String input){
        int longestStart = -1;
        int longestLength = 0;
        int count = 1;
        int start = 0;
        // your code goes here
        for(int i = 1; i < input.length(); i++) {
            if(input.charAt(i) == input.charAt(i-1)) {
                count++;
            }
            else {
                if(count > longestLength) {
                    longestLength = count;
                    longestStart = start;
                }
                start = i; // if chain breaks then consider current position as starting point and move through the array
                count = 1; // Reset the counter for count of the longest substring
            }
        }
        if(count > longestLength) {
            longestLength = count;
            longestStart = start;
        }
        return new int[]{ longestStart, longestLength };
    }
}
