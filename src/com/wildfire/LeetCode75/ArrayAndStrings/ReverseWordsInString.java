package com.wildfire.LeetCode75.ArrayAndStrings;

import java.util.Stack;

public class ReverseWordsInString {
    public static void main(String[] args) {
        String s = "  hello    world ";
        //System.out.println(reverseWords(s));
        System.out.println(reverseWordsOptimized(s));
    }

    //brute force approach
    public static String reverseWords(String s) {
        char[] charArr = s.toCharArray();
        Stack<Character> wordHolder = new Stack<>();
        String result = "";

        for (int i = charArr.length - 1; i >= 0; i--) {
            if (charArr[i] != ' ') {
                wordHolder.push(charArr[i]);
            } else {
                while (!wordHolder.empty()) {
                    result = result + wordHolder.pop();
                }
                if (result.length() != 0 && !result.endsWith(" ")) {
                    result = result + ' ';
                }
            }
        }

        while (!wordHolder.empty()) {
            result = result + wordHolder.pop();
        }
        return result.trim();
    }

    public static String reverseWordsOptimized(String s) {
        char[] str = s.toCharArray(), res = new char[s.length() + 1];
        // Initialize variables: i to track the index in the input string,
        // j to track the end index of the current word, and k to index the result array
        int i = s.length() - 1, j, k = 0;

        // Iterate through the input string from the end
        while (i >= 0) {
            // Skip over trailing whitespace characters
            while (i >= 0 && str[i] == ' ') {
                i--;
            }

            // If entire string has been processed, break out of the loop
            if (i < 0) break;

            // Store the end index of the current word
            j = i;

            // Move backward until the beginning of the current word is found
            while (i >= 0 && str[i] != ' ') {
                i--;
            }

            // Copy the characters of the current word to the result array
            for (int l = i + 1; l <= j; l++) {
                res[k++] = str[l];
            }

            // Add a space to separate words
            res[k++] = ' ';
        }

        // Return a new string created from the result array, excluding the trailing space character
        return new String(res, 0, k - 1);
    }

}
