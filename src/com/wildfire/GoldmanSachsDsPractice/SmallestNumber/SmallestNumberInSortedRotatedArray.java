package com.wildfire.GoldmanSachsDsPractice.SmallestNumber;

public class SmallestNumberInSortedRotatedArray {
    public static void main(String[] args) {
        int[] arr = { 5, 6, 1, 2, 3, 4};
        int N = arr.length;
        System.out.println("The smallest or minimum value is - " + findMin(arr, 0, N-1));
    }

    static int findMin(int[] arr, int start, int end){
        if(end < start)
            return arr[0];
        if(end == start)
            return arr[start];
        // find mid
        int mid = start + (end-start)/2;

        if(mid < end && arr[mid+1] < arr[mid])
            return arr[mid + 1];

        if(mid > start && arr[mid] < arr[mid-1])
            return arr[mid];

        if(arr[end] > arr[mid])
            return findMin(arr, start, mid-1);
        return findMin(arr, mid+1, end);

    }
}
