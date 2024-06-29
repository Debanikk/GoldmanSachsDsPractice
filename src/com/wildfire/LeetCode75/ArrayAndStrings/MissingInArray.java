package com.wildfire.LeetCode75.ArrayAndStrings;

public class MissingInArray {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 5 };
        int N = arr.length;
        System.out.println(5^6);
        // Function call
        int miss = missingNumber(N, arr);
        System.out.println("The missing number is - " + miss);
    }

    public static int missingNumber(int n, int arr[]) {
        int arrXor = arr[0];
        int x2 = 1;

        // For xor of all the elements in array
        for (int i = 1; i < arr.length; i++) {
            arrXor = arrXor ^ arr[i];
            System.out.println("arrXor value is - " + arrXor);
        }

        // For xor of all the elements from 1 to n+1
        for (int i = 2; i <= n + 1; i++) {
            x2 = x2 ^ i;
            System.out.println("x2 value is - " + x2);
        }

        return (arrXor ^ x2);
    }
}
