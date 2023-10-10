package com.wildfire.GoldmanSachsDsPractice.ArrayRotationAndOtherSubArrayProblems;

// Josephus problem of circular elimination of n-1 items
// from n items with subset of k items iteration
// and remainder position determination

import java.util.LinkedList;
import java.util.Queue;

/*****
 * There are N people standing in a circle waiting to be executed.
 * The counting out begins at some point in the circle and proceeds
 * around the circle in a fixed direction. In each step, a certain
 * number of people are skipped and the next person is executed. The
 * elimination proceeds around the circle (which is becoming smaller
 * and smaller as the executed people are removed), until only the
 * last person remains, who is given freedom.
 *
 * Given the total number of persons N and a number k which indicates
 * that k-1 persons are skipped and the kth person is killed in a circle.
 * The task is to choose the person in the initial circle that survives.
 * *****/

public class StudentElectionCircularArrangement {
    public static void main(String[] args) {
        checkTestResult();
        doTestsPass();
    }

    static boolean checkTestResult(){
        int[] arr = {7, 4, 2, 5, 9, 11, 13, 78, 34, 67};
        int k = 3;
        if(lastManStandingForFreedom(arr, k) == 5) {
            System.out.println("Tests Passed");
            return true;
        }
        else {
            System.out.println("Tests Failed");
            return false;
        }
    }

    public static int whoIsElected(int n, int k) {
        //your code
        if(n == 1) {
            return 1;
        }
        return (whoIsElected(n-1, k) + k-1)%n + 1; // solving using recursion
//    return -1;
    }

    public static boolean doTestsPass() {
        // todo: implement more tests, please
        // feel free to make testing more elegant
        // test cases are structered as {n, k, expected answer}
        /*int[][] testCases = {
                {1, 1, 1},
                {2, 2, 1},
                {4, 2, 1},
                {100, 2, 73},
                {5, 3, 4},
                {6, 4, 5},
                {1000, 5, 763}
        };*/
        int[][] testCases = {
                {7, 4, 2}
        };

        for (int[] testCase : testCases) {
            int answer = whoIsElected(testCase[0], testCase[1]);
            if (answer != testCase[2]) {
                System.out.println("test failed!");
                System.out.printf("n:%d, k%d, answer got: %d, should be: %d\n", testCase[0], testCase[1], answer, testCase[2]);
                return false;
            }
        }
        System.out.println("All tested passed");
        return true;
    }

    static int lastManStandingForFreedom(int[] arr, int k) {
        if (arr.length < k || arr == null) {
            return -1;
        }

        int result;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }

        while(queue.size() != 1) {
            int j = 1;
            while(j<k) {
                int temp = queue.peek();
                queue.add(temp);
                queue.remove();
                j++;
            }
            queue.remove();
        }
        result = queue.peek();
        return result;
    }
}
