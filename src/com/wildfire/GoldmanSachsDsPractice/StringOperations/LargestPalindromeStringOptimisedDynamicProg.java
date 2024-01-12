package com.wildfire.GoldmanSachsDsPractice.StringOperations;

public class LargestPalindromeStringOptimisedDynamicProg {
    public static void main(String[] args) {
        String str = "9912321456";
        System.out.println("Length is - " + longestPalSubStr(str));
    }

    static int longestPalSubStr(String str){
        int n = str.length();
        //edge case to handle when n = 0 and 1
        if(n < 2)
            return n;
        int maxLength = 1, start = 0;
        int low = 0, high = 0;
        for(int i = 0; i < n; i++){
            low = i - 1;
            high = i + 1;
            while(high < n && str.charAt(high) == str.charAt(i)){
                high++;
            }
            while(low >=0 && str.charAt(low) == str.charAt(i)){
                low--;
            }
            while(low >=0 && high < n && str.charAt(low) == str.charAt(high)){
                low--;
                high++;
            }
            int length = high - low -1;
            if (maxLength < length) {
                maxLength = length;
                start = low + 1;
            }
        }
        System.out.println("Longest Palindrome substring is: ");
        System.out.println(str.substring(start, start + maxLength));
        return maxLength;
    }


}
