package com.wildfire.GoldmanSachsDsPractice.LongestUniformSubstring;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestNonUniformSubstring {
    private static final Map<String, int[]> testCases = new HashMap<String, int[]>();

    public static void main(String[] args){

        String result1 = getUniqueCharacterSubstring("aaabcbdeaf");
        System.out.println(result1);
        //testCases.put("", new int[]{-1, 0});
        //testCases.put("10000111", new int[]{1, 4});
        //testCases.put("aabbbbbCdAA", new int[]{2, 5});
        testCases.put("aaabcbdeaf", new int[]{0,3});

        boolean pass = true;
        for(Map.Entry<String,int[]> testCase : testCases.entrySet()){
            int[] result = longestNonUniformSubstring(testCase.getKey());
            pass = pass && (Arrays.equals(result, testCase.getValue()));
        }
        if(pass){
            System.out.println("Pass!");
        } else {
            System.out.println("Failed! ");
        }
    }

    static int[] longestNonUniformSubstring(String input){
        int[] arr = new int[]{0,0};
        return arr;
    }

    static String getUniqueCharacterSubstring(String input) {
        Map<Character, Integer> visited = new HashMap<>();
        String output = "";
        for (int start = 0, end = 0; end < input.length(); end++) {
            char currChar = input.charAt(end);
            if (visited.containsKey(currChar)) {
                start = Math.max(visited.get(currChar)+1, start);
            }
            if (output.length() < end - start + 1) {
                output = input.substring(start, end + 1);
            }
            visited.put(currChar, end);
        }
        return output;
    }
}
