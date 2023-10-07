package com.wildfire.GoldmanSachsDsPractice.ArrayRotationAndOtherSubArrayProblems;

// find the length of minimum sub Array exceeding sum.
// ex: input : array is {1,2,3,4} sum = 6, output:length 2
public class SubArrayExceedingSum {
    public static int subArrayExceedsSum(int arr[], int target )
    {
        int count = 0;
        int sum = 0;
        int n = arr.length;
        //ask if only +ve int
        if(arr.length == 0) { return -1;}
        int p = 0;
        int q = 1;
        sum = arr[p];
        while(q <= arr.length) {
            if(sum > target) {
                count = count + n - q + 1;
                if(p == 0)
                {
                    count--;
                }
                sum -= arr[p];
                p++;
            }
            else {
                if(q < arr.length) {
                    sum += arr[q];
                }
                q++;
            }
        }
        if(count == 0) {
            return -1;
        }
        return count;

    }

    /**
     * Execution entry point.
     */
    public static void main(String[] args)
    {
        boolean result = true;
        int[] arr = { 1, 2, 3, 4 };
        result = result && subArrayExceedsSum( arr, 6 ) == 2;
        result = result && subArrayExceedsSum( arr, 12 ) == -1;

        if( result )
        {
            System.out.println("All tests pass\n");
        }
        else
        {
            System.out.println("There are test failures\n");
        }
    }
}
