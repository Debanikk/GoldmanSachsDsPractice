package com.wildfire.LeetCode75.RadixSort;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RadixSortMyVersion {
    // there are two ways of doing the radix sort.
    // One is the least significant digit radix we call it
    // LSD Radix sort. And the other one is the Most significant
    // digit radix sort or MSD Radix. Here we are doing the LSD Radix.
    public static void main(String[] args) {
        int[] arr = { 1012, 5221, 2212, 3234, 4753, 3417, 1532, 1020, -3417, -1532, -1020, -1012, -5221, -2212, -3234 };
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // the use of box() method allows us to transform the primitive int
    // type to the wrapper type Integer which allows us to use the partitionBy function
    public static void sort(int[] arr) {
        // the map will give us two set of values.
        // The true key will give us negative integers set as i -> i < 0 and
        // the false key will give us the positive integers
        Map<Boolean, List<Integer>> splitArray = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.partitioningBy(i -> i < 0));
        int[] negativeIntegers = radixSort(
                splitArray.get(true).stream()
                .mapToInt(Integer::intValue)
                .map(Math::abs)
                .toArray()
        );

        int[] positiveIntegers = radixSort(
                splitArray.get(false).stream()
                        .mapToInt(Integer::intValue)
                        .toArray()
        );

        for(int i = negativeIntegers.length - 1,j = 0; i >= 0; i--, j++){
            arr[j] = -negativeIntegers[i];
            System.arraycopy(positiveIntegers, 0, arr, negativeIntegers.length, positiveIntegers.length);
        }

    }

    // The disadvantage of using this technique of sort is that it can't handle any
    // negative integer. For negative integer we have to divide the array in two parts
    // and then remove the negation from the values and then sort using below algorithm.
    // upon sorting the negative array we have to add the negative sign again and then
    // while joining two sub arrays. we pick the elements from the negative array in
    // descending order.
    public static int[] radixSort(int[] arr) {
        int max = Arrays.stream(arr).max().orElse(Integer.MAX_VALUE);
        for(int exp = 1; max/exp > 0; exp *= 10) {
            CountingSort(arr, exp);
        }
        return arr;
    }

    public static void CountingSort(int[] arr, int exp) {

        int[] countArray = new int[10];

        for(int value: arr) {
            countArray[(value/exp) % 10]++;
        }
        for(int i = 1; i < 10; i++) {
            countArray[i] += countArray[i-1];
        }

        int[] output = new int[arr.length];
        for(int i = arr.length - 1; i >=0; i--) {
            int current = arr[i];
            int positionInArray = countArray[(current/exp) % 10] - 1;
            output[positionInArray] = current;
            countArray[(current/exp) % 10]--;
        }
        System.arraycopy(output, 0, arr, 0, arr.length);
    }
}
