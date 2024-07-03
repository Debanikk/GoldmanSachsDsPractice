package com.wildfire.LeetCode75.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class SubStringWithAllVowels {
    public static void main(String[] args) {
        System.out.println("Minimum length of substring that contains all the vowels is - " + getSubStringLength("wdaeiaweiduoweiou"));
    }

    static int getSubStringLength(String text) {
        int[] map = new int[128];
        String vowels = "aeiou";
        int count = vowels.length();
        int start = 0, end = 0, startIndex = 0, minLen = Integer.MAX_VALUE;
        for(char ch : vowels.toCharArray()) {
            map[ch]++;
        }
        char[] str = text.toCharArray();
        while(end <str.length) {
            if(map[str[end]] > 0) {
                count--;
            }
            map[str[end]]--;
            end++;
            while(count == 0) {
                if(end - start < minLen) {
                    startIndex = start;
                    minLen = end - start;
                }
                if(map[str[start]] == 0) {
                    count++;
                }
                map[str[start]]++;
                start++;
            }
        }
        if(minLen == Integer.MAX_VALUE)
            return 0;
        System.out.println(text.substring(startIndex, startIndex + minLen));
        return minLen;
    }
}
