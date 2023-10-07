package com.wildfire.GoldmanSachsDsPractice.SmallestNumber;

public class SecondSmallestNumberInSortedRotatedArray {
    public static void main(String[] args) {
        int[] arr = {5,6,1,2,3,4};
        System.out.println("Second largest number is : " + findSecondMin(arr, arr.length));
    }

    static int findSecondMin(int[] arr, int length){
        if(arr.length < 1)
            return 0;
        if(arr.length <= 2)
            return arr[0];

        int min = Integer.MAX_VALUE;
        int min1 = Integer.MAX_VALUE;
        for(int i = 0; i < length; i++){
            if(arr[i] <= min){
                min1 = min;
                min = arr[i];
            }
            else if (arr[i] < min1){
                min1 = arr[i];
            }
        }
        return min1;
    }
}
