package com.wildfire.GoldmanSachsDsPractice.ArrayRotationAndOtherSubArrayProblems;

public class IncreasingDecreasingOrderArrayPrinting {
    public static void main(String[] args) {
        int[] arr = {5, 4, 6, 2, 1, 3, 8, 9, -1};
        int k = 4;
        printArray(SortedArray(arr, k));
    }

    static void printArray(int[] arr){
        for(int i =0; i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }

    static int[] SortedArray(int[] arr, int k){
        int[] resultArr = new int[arr.length];
        int[] arr1 = new int[k];
        int[] arr2 = new int[arr.length -k];
        for(int i = 0; i<k; i++){
            arr1[i] = arr[i];
        }

        int index = 0;
        for(int i = k; i<arr.length; i++){
            System.out.println(" arr[k] is : " + arr[k] + " and index is :  " + index + " and k is: " + k + " arr[i] is: " + arr[i]);
            arr2[index] = arr[i];
            index++;
        }

        QuickSort(arr1, 0, arr1.length - 1);
        QuickSort(arr2, 0, arr2.length - 1);

        // For array post sort check and print
        for(int i = 0; i < arr1.length; i++){
            System.out.println(" arr1 value in index i - " + i + " is - " + arr1[i]);
        }

        // For array post sort check and print
        for(int i = 0; i < arr2.length; i++){
            System.out.println(" arr2 value in index i - " + i + " is - " + arr2[i]);
        }

        int len2 = arr.length - k;
        for(int i = 0; i < arr.length; i++){
            if(i < k)
                resultArr[i] = arr1[i];
            else{
                resultArr[i] = arr2[len2-1];
                len2--;
            }
        }
        return resultArr;
    }

    static void QuickSort(int[] arr, int start, int end){
        if(start<end){
            int pivot = partition(arr, start, end);
            QuickSort(arr, start, pivot-1);
            QuickSort(arr, pivot+1, end);
        }
    }

    static int partition(int[] arr, int start, int end){
        int pivot = arr[end];
        int p_index = start;
        for(int j = start; j<end; j++){
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
