package com.wildfire.GoldmanSachsDsPractice.SnowProblem;


// Time complexity - O(N) space complexity - O(N)
public class SnowCollectionProblem {
    public static void main(String[] args) {
        int[] arr = {0, 1, 3, 0, 1, 2, 0, 4, 2, 0, 3, 0};
        System.out.println("Snow Collected is : " + getSnow(arr));
    }

    private static Integer computeSnowpack(final Integer[] buildingHeight) {
        int result = 0;

        int leftMax = 0, rightMax = 0;

        // indices to traverse the array
        int low = 0, high = buildingHeight.length - 1;

        while (low <= high) {
            if (buildingHeight[low] < buildingHeight[high]) {
                if (buildingHeight[low] > leftMax) leftMax = buildingHeight[low];
                else result += leftMax - buildingHeight[low];
                low++;
            } else {
                if (buildingHeight[high] > rightMax) rightMax = buildingHeight[high];
                else result += rightMax - buildingHeight[high];
                high--;
            }
        }

        return result;
    }

    static int getSnow(int[] arr) {
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];

        // fill left array with maximum to main array on index basis of i and i+1
        left[0] = right[0];
        for (int i = 1; i < arr.length; i++) {
            left[i] = Math.max(arr[i], left[i - 1]);
        }

        // fill right array with difference to main array on index basis of i and i+1
        // Fill right most cell with 0 value
        right[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            right[i] = Math.max(arr[i], right[i + 1]);
        }

        int snowCollected = 0;
        for (int i = 0; i < arr.length; i++) {
            int min = Math.min(left[i], right[i]);
            snowCollected += min - arr[i];
        }

        return snowCollected;
    }
}
