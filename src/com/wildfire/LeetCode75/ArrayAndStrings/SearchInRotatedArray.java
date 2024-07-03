package com.wildfire.LeetCode75.ArrayAndStrings;

public class SearchInRotatedArray {
    public static void main(String[] args) {
        int[] nums = { 5, 6, 1, 2, 3, 4};
        int target = 4;
        int index = searchElement(nums, target);
        if (index != -1) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found in the array.");
        }
    }

    static int searchElement(int[] arr, int key) {
        if(arr.length < 1)
            return -1;
        int left = 0, right = arr.length - 1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(arr[mid] == key)
                return mid;

            if(arr[left] <= arr[mid]) {
                if(arr[left] <= key && key < arr[mid]) {
                    right = mid -1;
                }
                else {
                    left = mid + 1;
                }
            }
            else {
                if(arr[mid] < key && key <= arr[right]) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
