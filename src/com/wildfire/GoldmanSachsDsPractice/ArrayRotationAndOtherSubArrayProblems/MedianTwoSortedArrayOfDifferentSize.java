package com.wildfire.GoldmanSachsDsPractice.ArrayRotationAndOtherSubArrayProblems;

public class MedianTwoSortedArrayOfDifferentSize {
    public static void main(String[] args) {
        int[] arr1 = { -5, 3, 6, 12, 15 };
        int[] arr2 = { -12, -10, -6, -3, 4, 10 };

        double median = findMedianOfSortedUnEqualArrays(arr1, arr2);
        System.out.println("Median of two arrays is - " + median);

        int result = getMedianOfArrays(arr1, arr2);
        System.out.println("Median of two arrays is - " + result);
    }

    // use this one - Time complexity -> O(log(min(m,n))
    private static double findMedianOfSortedUnEqualArrays(int[] arr1, int[] arr2) {
        // Make sure that the left array size is always smaller than the right one
        if(arr1.length > arr2.length) {
            return findMedianOfSortedUnEqualArrays(arr2, arr1);
        }

        /// get size for both of the arrays
        int lenX = arr1.length;
        int lenY = arr2.length;

        int low = 0;
        int high = lenX;

        // start Binary search process
        while( low <= high) {
            int partitionX = (low + high)/2;
            int partitionY = (lenX + lenY + 1)/2 - partitionX;

            // case 1 : if partitionX is 0, then there are no elements on the left side of the bucket. So we use -INF for maxLeft
            // case 2: if partitionX length is total length of input then there are no elements on the right side, and we use +INF for minRight

            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : arr1[partitionX - 1];
            int minRightX = (partitionX == lenX) ? Integer.MAX_VALUE : arr1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : arr2[partitionY - 1];
            int minRightY = (partitionY == lenY) ? Integer.MAX_VALUE : arr2[partitionY];

            if(maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if((lenX + lenY)%2 == 0) {
                    return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
                }
                else {
                    return (double)Math.max(maxLeftX, maxLeftY);
                }
            }
            else if(maxLeftX > minRightY) {
                high = partitionX - 1;
            }
            else {
                low = partitionX + 1;
            }
        }
        throw new IllegalArgumentException();
    }

    // don't use this one
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
