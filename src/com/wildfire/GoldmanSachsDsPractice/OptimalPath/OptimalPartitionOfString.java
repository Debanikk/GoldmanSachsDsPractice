package com.wildfire.GoldmanSachsDsPractice.OptimalPath;

import java.util.HashSet;
import java.util.Set;

public class OptimalPartitionOfString {
    public static void main(String[] args) {
        int result = getMaxPartitionFromStringUsingSet("abacaba");
        System.out.println("result is - " + result);
    }

    private static int getMaxPartitionFromStringUsingSet(String s) {
        int result = 1;
        Set<Character> set = new HashSet<>();

        for(char c : s.toCharArray()) {
            if(set.contains(c)) {
                result++;
                set.clear();
            }
            set.add(c);
        }
        return result;
    }

    /// BIT APPROACH. Need to check teh flag assignment how it works in java
    private static int getMaxPartitionFromString(String s) {
        int i = 0, result = 1, flag = 0;
        /*while(i < s.length()) {
            int val = s.charAt(i);
            if(flag && (1<<val)) {
                flag = 0;
                result++;
            }
            flag = flag | (1<<val);
            i++;
        }*/
        return result;
    }
}
