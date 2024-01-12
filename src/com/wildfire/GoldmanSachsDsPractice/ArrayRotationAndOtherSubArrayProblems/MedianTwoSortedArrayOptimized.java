package com.wildfire.GoldmanSachsDsPractice.ArrayRotationAndOtherSubArrayProblems;

public class MedianTwoSortedArrayOptimized {
    public static void main(String[] args) {
        // The solution does not work for the below input/ Test case. Hence, this is not recommended.
        int[] arr1 = new int[]{1,2,3,5,6};
        int[] arr2 = new int[]{4};
        //int[] arr1 = { 1, 12, 15, 26, 38 };
        //int[] arr2 = { 2, 13, 17, 30, 45 };
        System.out.println("Median of two sorted array is - " + findMedian(arr1, arr2, 0, 0, arr1.length - 1, arr2.length - 1));
    }

    static int median(int[] arr, int start, int end) {
        int arrLength = end - start + 1;
        // check if length is even or odd
        if(arrLength % 2 == 0) {
            return (arr[start + (arrLength / 2)]
                    + arr[start + (arrLength / 2 - 1)])
                    / 2;
        }
        else {
            return arr[start + arrLength/2];
        }
    }

    /// This solution will provide a Time complexity of O(logN) and space complexity of O(1)
    static int findMedian(int[] arr1, int[] arr2, int start_a1, int start_a2, int end_a1, int end_a2) {
        //base condition
        if(end_a1 - start_a1 == 1) {
            return ((Math.max(start_a1, start_a2)) + Math.min(end_a1, end_a2))/2;
        }
        // median of the first array
        int m1 = median(arr1, start_a1, end_a1);
        // median of second array
        int m2 = median(arr2, start_a2, end_a2);

        if(m1 == m2) {
            return m1;
        }
        else if (m1 < m2) {
            return findMedian(arr1, arr2, (end_a1 + start_a1 + 1) / 2,
                    start_a2, end_a1,
                    (end_a2 + start_a2 + 1) / 2);
        }
        else {
            return findMedian(arr1, arr2, start_a1,
                    (end_a2 + start_a2 + 1) / 2,
                    (end_a1 + start_a1 + 1) / 2, end_a2);
        }
    }
}
