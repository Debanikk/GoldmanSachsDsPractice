package com.wildfire.LeetCode75.SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String largeString = "ADOBECODEBANC";
        String smallString = "ABC";

        System.out.println("Minimum window substring is - " + minWindow(largeString, smallString));

    }


    public static String minWindow(String s, String t) {
        // create an array to hold the character map
        int[] map = new int[128];
        int count = t.length();
        int start = 0, end = 0, minLen = Integer.MAX_VALUE, startIndex = 0;

        // insert and mark the characters in small string in the map array as 1 and rest will be marked as 0
        for(char c: t.toCharArray())
            map[c]++;

        char[] S = s.toCharArray();

        // creation of sliding window - traverse through the array
        // by using end as the right pointer to get new char to compare
        // with chars in map array. if found decrease the count in the map
        // array and total counter as well.
        while(end < S.length){
            if(map[S[end]] > 0)
                count--;
            map[S[end]]--;
            end++;

            while(count == 0){
                if(end - start < minLen){
                    startIndex = start;
                    minLen = end - start;
                }

                if(map[S[start]] == 0)
                    count++;
                map[S[start]]++;
                start++;
            }
        }

        if(minLen == Integer.MAX_VALUE) return new String();
        return s.substring(startIndex, startIndex+minLen);
    }

    /// Not optimized. Has a higher run time
    public static String minWindowPartialSolution(String s, String t) {
        String result = "";
        if(t.length() > s.length())
            return result;
        // small letter character starts from 65 and capital letter starts from 97,
        // and we have 2226 letters so 97 + 26 gives 123, as a buffer we took 128 space
        int[] tCount = new int[128];
        //This iteration will give us an array where chars in t array will be marked as 1 and rest as 0
        for(char ch : t.toCharArray()) {
            tCount[ch]++;
        }

        // declare variables
        int left = 0, right = 0, toFind = t.length(), found = 0;
        int minWindowLength = Integer.MAX_VALUE;
        char[] sArr = s.toCharArray();
        // traverse via right pointer through the larger array
        while(right < s.length()) {
            // check teh current char in the large array and compare it with our tCount array,
            // if matches then decrease the count of tCount array for teh same letter by 1
            char ch = sArr[right];
            tCount[ch]--;

            // now check the same tCount array and if the counter
            // for the char found is greater than equals 0 then
            // we have encountered one char
            if(tCount[ch] >= 0) {
                found++;
            }
            // try to balance and traverse the unused chars
            while( found == toFind) {
                //minWindowLength = Math.min(minWindowLength, right - left + 1);
                //result = s.substring(left, right + 1);
                if(minWindowLength > (right - left + 1)) {
                    minWindowLength = right - left + 1;
                    result = s.substring(left, right + 1);
                }

                tCount[sArr[left]]++;
                if(tCount[sArr[left]] > 0) {
                    found--;
                }
                left++;
            }
            right++;
        }
        return result;
    }


}
