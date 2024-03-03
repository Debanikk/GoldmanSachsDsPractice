package com.wildfire.GoldmanSachsDsPractice.ArrayRotationAndOtherSubArrayProblems;

public class RainWaterHarvestingContainer {
    public static void main(String[] args) {
        //int[] container = new int[] {1,8,6,2,5,4,8,3,7}; // 1,2,1 // 1,2,4,3 // 1,0,0,0,0,0,0,2,2 // 2,3,4,5,18,17,6
        int[] container = new int[] {1,2,1};
        int result = getMaxContainerSize(container);
        System.out.println("Container size is - " + result);
    }
    /*public static int getMaxContainerSize(int[] arr) {
        if(arr.length < 2)
            return 0;
        int leftIndex = 0, rightIndex = leftIndex + 1;
        int containerSize =  arr[leftIndex] >= arr[rightIndex] ? arr[rightIndex] * (rightIndex - leftIndex) : arr[leftIndex] * (rightIndex - leftIndex);

        while(rightIndex < arr.length) {
            if(rightIndex < arr.length) {
                int tempSize = Math.min(arr[leftIndex], arr[rightIndex]) * (rightIndex - leftIndex);
                if (tempSize > containerSize) {
                    containerSize = tempSize;
                }
            }

            if(rightIndex < arr.length && arr[rightIndex] > arr[leftIndex] && (rightIndex - leftIndex) != 1 && arr[leftIndex + 1] > arr[leftIndex]) {
                leftIndex++;
            }
            rightIndex++;
        }
        return containerSize;
    }*/

    public static int getMaxContainerSize(int[] arr) {
        int leftIndex = 0, rightIndex = arr.length - 1;
        int containerSize = 0;
        int tempSize = 0;
        while(leftIndex < rightIndex) {
            tempSize = Math.min(arr[leftIndex], arr[rightIndex]) * (rightIndex - leftIndex);
            if(tempSize > containerSize) {
                containerSize = tempSize;
            }

            if(arr[leftIndex] < arr[rightIndex]) {
                leftIndex++;
            }
            else{
                rightIndex--;
            }
        }
        return containerSize;
    }
}
