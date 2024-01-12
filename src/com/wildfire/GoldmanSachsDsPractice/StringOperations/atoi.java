package com.wildfire.GoldmanSachsDsPractice.StringOperations;

public class atoi {
    //ASCII to Integer
    // Takes a string str and returns the int value represented by
    // the string.
    //For example, atoi("42") returns 42.

    public static int atoi(String str) {
        if(str.equals(""))
            return 0;

        //helper variables
        int res = 0, i = 0, sign = 1;

        // white space removal
        while(i < str.length() && str.charAt(i) == ' ') {
            i++;
        }

        //check for the sign
        if(i < str.length() && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
            if(str.charAt(i++) == '-') {
                sign = -1;
            }
        }

        // now for checking numbers only
        // should be between 0 and 9 only
        while(i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            if(res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) {
                if(sign == -1) {
                    return Integer.MIN_VALUE;
                }
                return Integer.MAX_VALUE;
            }
            // update res
            res = res * 10 + (str.charAt(i++) - '0');
        }
        System.out.println("The integer value is: " + (sign * res));
        return sign * res;
    }

    public static boolean pass() {
        boolean result = true;
        //result = result && (atoi("3") == 3);
        result = result && (atoi("   2147483648 and whatever it is") == 2147483647);

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
