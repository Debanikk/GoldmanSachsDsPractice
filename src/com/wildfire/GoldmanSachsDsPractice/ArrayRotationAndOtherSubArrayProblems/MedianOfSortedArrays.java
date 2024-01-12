package com.wildfire.GoldmanSachsDsPractice.ArrayRotationAndOtherSubArrayProblems;

public class MedianOfSortedArrays {
    public static void main(String[] args) {
        int[] num1 = new int[]{1,2,3,5,6};
        int[] num2 = new int[]{4};
        Double resMedian = getMedianOfSortedArrays(num1, num2);
        System.out.println("Median value is " + resMedian);
    }

    public static double getMedianOfSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1 == 0)
            return getMedianOfSortedArrays(nums2, nums2);
        if(n2 == 0)
            return getMedianOfSortedArrays(nums1, nums1);
        if(n1 == 0 && n2 == 0)
            return 0;

        if(n1 > n2)
            return getMedianOfSortedArrays(nums2, nums1);

        int n = n1 + n2; //get total length of elements in both arrays
        int left = (n1 + n2 + 1)/2; // get partition element index for larger array
        int low = 0, high = n1;

        while(low <= high) {
            int mid1 = (low + high) >> 1; // this is like dividing with 2 but without getting and fraction result
            int mid2 = left - mid1;
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE, r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;

            // determine values for the l1, l2, r1, r2
            if(mid1 < n1)
                r1 = nums1[mid1];
            if(mid2 < n2)
                r2 = nums2[mid2];
            if(mid1 - 1 >= 0)
                l1 = nums1[mid1-1];
            if(mid2-1 >= 0)
                l2 = nums2[mid2-1];

            // check if partition is correct or not
            if(l1 <= r2 & l2 <= r1) {
                // if partition is correct then it will reach here
                if(n%2 == 1){
                    return Math.max(l1, l2);
                }
                else {
                    return ((double)(Math.max(l1, l2) + Math.min(r1, r2)))/2.0;
                }
            }
            else if(l1 > r2) {
                //move towards the left side of the array
                high = mid1 - 1;
            }
            else {
                // move towards the left side of the array
                low = mid1 + 1;
            }
        }
        return 0;
    }
}
