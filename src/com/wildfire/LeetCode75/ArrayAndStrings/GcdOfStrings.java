package com.wildfire.LeetCode75.ArrayAndStrings;

public class GcdOfStrings {
    public static void main(String[] args) {

    }

    public static String gcdOfStrings(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int divisor = 0;
        if(n < m) {
            /*if(!str2.contains(str1)) {
                return "";
            }*/
            while(n != 0) {
                if(str2.contains(str1)) {

                }
            }
        }
        else if (n > m){
            if(!str1.contains(str2)) {
                return "";
            }
        }
        else {
            if(!str1.equals(str2)) {
                return "";
            }
        }

        return "";
    }
}
