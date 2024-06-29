package com.wildfire.LeetCode75.CountingSort;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] arr = { 5, 0, 7, 3, -2, 2, 9 };
        int[] arr2 = { 5, 0, 7, 3, -2, 2, 9 };
        int[] arr3 = { 5, 0, 7, 3, -2, 2, 9 };
        System.out.println("The values before sort!!");
        System.out.println(Arrays.toString(arr));
        sortAscending(arr);
        System.out.println("The values after sort in Ascending order!!");
        System.out.println(Arrays.toString(arr));

        System.out.println("The values before sort!!");
        System.out.println(Arrays.toString(arr2));
        sortDescending(arr2);
        System.out.println("The values after sort in Descending order!!");
        System.out.println(Arrays.toString(arr2));

        System.out.println("The values before sort!!");
        System.out.println(Arrays.toString(arr3));
        sortAscendingExtraSpace(arr3);
        System.out.println("The values after sort in Ascending order with extra space technique!!");
        System.out.println(Arrays.toString(arr3));
    }

    public static void sortAscending(int[] arr) {
        // find max the and min value in the array element
        int min = Arrays.stream(arr).min().orElse(0);
        int max = Arrays.stream(arr).max().orElse(Integer.MAX_VALUE);

        // create an array with extra space for holding the
        // elements as per their value as index in the new array
        int[] countArray = new int[max - min + 1];

        // iterate through the array for adding the element in the new array
        // with index value as value - min and increment the array index value as a counter
        for(int value: arr) {
            countArray[value - min]++;
        }

        System.out.println("The 0 means there is no element for that index (value - min) value in the main array");
        System.out.println("The new counting sort array is - ");
        System.out.println(Arrays.toString(countArray));

        // start filling in the main array with index starting from 0 and
        // decrement the counter value from the new array index as we keep
        // pulling element out of it
        int arrayIndex = 0;
        for(int i = 0; i < max - min + 1; i++) {
            // the while loop is there for handling same value element
            while(countArray[i] > 0) {
                arr[arrayIndex] = i + min;
                countArray[i]--;
                arrayIndex++;
            }
        }
    }

    public static void sortDescending(int[] arr) {
        // find the max and min value in the array element
        int min = Arrays.stream(arr).min().orElse(0);
        int max = Arrays.stream(arr).max().orElse(Integer.MAX_VALUE);

        // create an array with extra space for holding the
        // elements as per their value as index in the new array
        int[] countArray = new int[max - min + 1];

        // iterate through the array for adding the element in the new array
        // with index value as value - min and increment the array index value as a counter
        for(int value: arr) {
            countArray[value - min]++;
        }

        System.out.println("The 0 means there is no element for that index (value - min) value in the main array");
        System.out.println("The new counting sort array is - ");
        System.out.println(Arrays.toString(countArray));

        // start filling in the main array with index starting from 0 and
        // decrement the counter value from the new array index as we keep
        // pulling element out of it
        int arrayIndex = 0;
        for(int i = max - min; i >= 0; i--) {
            // the while loop is there for handling same value element
            while(countArray[i] > 0) {
                arr[arrayIndex] = i + min;
                countArray[i]--;
                arrayIndex++;
            }
        }
    }

    // in this technique we are going to use an operation on our
    // counting sort array with formula countArray[i] += countArray[i-1] as
    // this will give us the actual elements in the array while value shift is observed
    public static void sortAscendingExtraSpace(int[] arr) {
        int max = Arrays.stream(arr).max().orElse(Integer.MAX_VALUE);
        int min = Arrays.stream(arr).min().orElse(0);

        int[] countArray = new int[max - min + 1];

        for(int value: arr) {
            countArray[value-min]++;
        }
        for(int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[i-1];
        }

        // here we need to use a new array as an output as we can not replace
        // the values in the arr (Main array) as we will be iterating through it.
        int[] output = new int[arr.length];
        for(int i = arr.length - 1; i >=0; i--){
            int current = arr[i];
            // here we find the position of the array from the calculated array using the value - min formula
            // and then subtract 1 from it to get the actual index position in the output array
            int positionInArray = countArray[current - min] - 1;
            output[positionInArray] = current;
            countArray[current - min]--;
        }
        // finally we copy the value from the temp output array to the main array
        // index by index as our motto was to sort the main array itself.
        System.arraycopy(output, 0, arr, 0, arr.length);
    }
}
