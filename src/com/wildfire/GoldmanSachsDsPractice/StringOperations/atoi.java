package com.wildfire.GoldmanSachsDsPractice.StringOperations;

public class atoi {
    //ASCII to Integer
    // Takes a string str and returns the int value represented by
    // the string.
    //For example, atoi("42") returns 42.

    public static int atoi(String str) {
        int result = 0;
        int strLength = str.length();

        for (int i = 0; i < strLength; i++) {
            result = result * 10 + str.charAt(i) - '0';
        }
        return result;
    }

    public static boolean pass() {
        boolean result = true;
        result = result && (atoi("3") == 3);
        result = result && (atoi("1") != 2);

        return result;
    }

    public static void main(String[] args) {
        if (pass()) {
            System.out.println("Pass");
        } else {
            System.out.println("Some fail");
        }

    }
}
