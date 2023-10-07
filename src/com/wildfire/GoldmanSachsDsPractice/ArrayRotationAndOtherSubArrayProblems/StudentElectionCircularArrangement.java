package com.wildfire.GoldmanSachsDsPractice.ArrayRotationAndOtherSubArrayProblems;

// Josephus problem of circular elimination of n-1 items
// from n items with subset of k items iteration
// and remainder position determination
public class StudentElectionCircularArrangement {
    public static void main(String[] args) {
        doTestsPass();
    }

    public static int whoIsElected(int n, int k) {
        //your code
        if(n == 1) {
            return 1;
        }
        return (whoIsElected(n-1, k) + k-1)%n + 1;
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
}
