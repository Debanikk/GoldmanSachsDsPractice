package com.wildfire.GoldmanSachsDsPractice.SmallestNumber;

public class SecondSmallestNumberInUnsortedArray {
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 4, 5, 2};
        QuickSort(arr, 0, arr.length - 1);
        if(DoTests(arr))
            System.out.println("Sort is successful and second smallest number is - " + arr[1] + " and 4th Smallest Number is - " + arr[3]);
        else
            System.out.println("Test failed and sorting failed as well");
    }

    static Boolean DoTests(int[] arr){
        return arr[1] == 2 && arr[2] == 4;

    }

    static void QuickSort(int[] arr, int start, int end){
        if(start<end) {
            int pivot = Partition(arr, start, end);
            QuickSort(arr, start, pivot - 1);
            QuickSort(arr, pivot + 1, end);
        }
    }

    static int Partition(int[] arr, int start, int end){
        int pivot = arr[end];
        int p_index = start;
        for(int j = start; j < end; j++){
            if(arr[j] <= pivot){
                int temp1 = arr[j];
                arr[j] = arr[p_index];
                arr[p_index] = temp1;
                p_index++;
            }
        }
        int temp2 = arr[p_index];
        arr[p_index] = arr[end];
        arr[end] = temp2;

        return p_index;
    }
}
