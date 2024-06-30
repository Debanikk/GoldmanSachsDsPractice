package com.wildfire.LeetCode75.ArrayAndStrings;

public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {2,2,1,3,2,2,1};
        int majorityElement = getMajorityElement(arr);
        System.out.println("The majority element is - " + majorityElement);
    }

    // if there is a majority element always present in the array
    // then this will be the optimal solution else try using the other method
    static int getMajorityElement(int[] arr) {
        int majority = arr[0], votes = 1;
        for(int i = 1; i < arr.length; i++) {
            if(votes == 0) {
                votes++;
                majority = arr[i];
            }
            else if(majority == arr[i]) {
                votes++;
            }
            else {
                votes--;
            }
        }
        return majority;
    }

    static int checkMajorityElement(int[] arr, int size) {
        int majority = arr[0], votes = 1;
        for(int i = 1; i < arr.length; i++) {
            if(votes == 0) {
                votes++;
                majority = arr[i];
            }
            else if(majority == arr[i]) {
                votes++;
            }
            else {
                votes--;
            }
        }
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            if(majority == arr[i]) {
                count++;
            }
        }
        if(count > size/2) {
            return majority;
        }
        return -1;
    }
}
