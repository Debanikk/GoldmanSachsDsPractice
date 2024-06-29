package com.wildfire.LeetCode75.BinaryAndBit;


/// given a binary number check if the number is divisible by 3.
/// It is recommended to finish the task using one traversal of input binary number.
/// Expected Time Complexity: O(|S|)where S is the size of the input
/// Expected Auxiliary Space: O(1)

/*
*
* */
public class MultipleOfThree {
    public static void main(String[] args) {
        System.out.println(isDivisible(""));
    }

    public static int isDivisible(String s){
        int sum = 0;
        for( int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1') {
                if(i % 2 == 0) {
                    sum += 1;
                }
                else {
                    sum += 2;
                }
            }
        }

        return sum % 3 == 0 ? 1 : 0;
    }
}
