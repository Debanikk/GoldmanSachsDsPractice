package com.wildfire.LeetCode75.ArrayAndStrings;

import java.util.LinkedList;
import java.util.List;

public class GcdOfStrings {
    public static void main(String[] args) {
        System.out.println("The greatest common divisor of two strings are - " + gcdOfStrings("ABCABC", "ABC"));
    }

    public static String gcdOfStrings(String str1, String str2) {
        String bigger = str1.length() > str2.length() ? str1 : str2;
        String smaller = str1.length() > str2.length() ? str2 : str1;

        if(bigger.equals(smaller)) {
            return smaller;
        }
        if(!bigger.startsWith(smaller)) {
            return "";
        }

        return gcdOfStrings(bigger.substring(smaller.length()), smaller);
    }
}
