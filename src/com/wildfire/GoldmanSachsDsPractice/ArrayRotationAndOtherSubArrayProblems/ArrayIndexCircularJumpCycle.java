package com.wildfire.GoldmanSachsDsPractice.ArrayRotationAndOtherSubArrayProblems;

public class ArrayIndexCircularJumpCycle {
    /**
     *
     * You have an integer array.
     * Starting from arr[startIndex], follow each element to the index it points to.
     * Continue to do this until you find a cycle.
     * Return the length of the cycle. If no cycle is found return -1
     *
     */

    public static int findCount(int[] arr, int slow) {
        int loopLength = 1;
        int index = arr[slow];
        while (index != slow) {
            index = arr[index];
            loopLength++;
        }
        return loopLength;
    }

    public static int countLengthOfCycle(int[] arr, int startIndex) {
        int slow = startIndex, fast = startIndex;
        int index = 0;
        while (index < arr.length) {
            index++;
            slow = arr[slow];
            fast = arr[arr[fast]];
            if (slow == fast) {
                return findCount(arr, slow);
            }
        }

        return -1;
    }


    public static void main(String[] args) {

        boolean testsPassed = true;
        testsPassed &= countLengthOfCycle(new int[]{1, 2, 3, 1}, 0) == 3;
        testsPassed &= countLengthOfCycle(new int[]{1, 0}, 0) == 2;
        testsPassed &= countLengthOfCycle(new int[]{1, 2, 0}, 0) == 3;

        if (testsPassed) {
            System.out.println("Test passed.");
            //return true;
        } else {
            System.out.println("Test failed.");
            //return false;
        }


    }
}
