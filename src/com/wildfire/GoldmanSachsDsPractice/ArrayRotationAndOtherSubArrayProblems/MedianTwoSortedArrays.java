package com.wildfire.GoldmanSachsDsPractice.ArrayRotationAndOtherSubArrayProblems;

public class MedianTwoSortedArrays {
    public static void main(String[] args) {
        if(doTests())
            System.out.println("Median is found");
        else
            System.out.println("Error in logic");
    }

    // TEST method and driver code for finding median
    // Array values would be defined here
    public static Boolean doTests() {
        boolean result = true;

        int arr1[] = {1, 12, 15, 26, 38};
        int arr2[] = {2, 13, 17, 30, 45};

        int n1 = arr1.length;
        int n2 = arr2.length;

        int med = 0;
        if (n1 == n2) {
            med = getMedian(arr1, arr2, n1);
            result = result && med == 16;
            System.out.println("Median of given array is - " + med);
        }
        else
            System.out.println("arrays are of unequal size");

        return result;
    }

    static int getMedian(int ar1[], int ar2[], int n) {
        int i = 0;
        int j = 0;
        int count;
        int m1 = -1;
        int m2 = -1;

        /* Since there are 2n elements, median will
           be average of elements at index n-1 and
           n in the array obtained after merging ar1
           and ar2 */
        for (count = 0; count <= n; count++)
        {
            /* Below is to handle case where all
              elements of ar1[] are smaller than
              smallest(or first) element of ar2[] */
            if (i == n)
            {
                m1 = m2;
                m2 = ar2[0];
                break;
            }

            /* Below is to handle case where all
               elements of ar2[] are smaller than
               smallest(or first) element of ar1[] */
            else if (j == n)
            {
                m1 = m2;
                m2 = ar1[0];
                break;
            }
            /* equals sign because if two
               arrays have some common elements */
            if (ar1[i] <= ar2[j])
            {
                /* Store the prev median */
                m1 = m2;
                m2 = ar1[i];
                i++;
            }
            else
            {
                /* Store the prev median */
                m1 = m2;
                m2 = ar2[j];
                j++;
            }
        }

        return (m1 + m2)/2;
    }
}
