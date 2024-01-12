package com.wildfire.GoldmanSachsDsPractice.ArrayRotationAndOtherSubArrayProblems;

public class MedianTwoSortedArrayOfDifferentSize {
    public static void main(String[] args) {
        int[] arr1 = { -5, 3, 6, 12, 15 };
        int[] arr2 = { -12, -10, -6, -3, 4, 10 };

        int result = getMedianOfArrays(arr1, arr2);
        System.out.println("Median of two arrays is - " + result);
    }

    static int getMedianOfArrays(int[] arr1, int[] arr2) {
        int arrLen1 = arr1.length;
        int arrLen2 = arr2.length;
        int i = 0; // current index for arr1
        int j = 0; // current index for arr2
        int count;
        int m1 = -1; int m2 = -1;

        if((arrLen1 + arrLen2) % 2 == 1) {
            for(count = 0; count <= (arrLen1 + arrLen2)/2; count++) {
                if(i != arrLen1 && j != arrLen2) {
                    m1 = (arr1[i] > arr2[j]) ? arr2[j++] : arr1[i++];
                }
                else if(i < arrLen1) {
                    m1 = arr1[i++];
                }
                else{
                    m1 = arr2[j++];
                }
            }
            return m1;
        }
        else {
            for(count = 0; count <= (arrLen1 + arrLen2)/2; count++) {
                m2 = m1;
                if(i != arrLen1 && j != arrLen2) {
                    m1 = (arr1[i] > arr2[j]) ? arr2[j++] : arr1[i++];
                }
                else if(i < arrLen1) {
                    m1 = arr1[i++];
                }
                else {
                    m1 = arr2[j++];
                }
            }
            return (m1 + m2)/2;
        }
    }
}
