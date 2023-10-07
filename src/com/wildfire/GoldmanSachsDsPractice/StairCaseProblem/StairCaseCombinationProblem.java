package com.wildfire.GoldmanSachsDsPractice.StairCaseProblem;

public class StairCaseCombinationProblem {
    public static void main(String[] args) {
        System.out.println("Test results are fine for combination - " + doTests());
    }


    public static Boolean doTests(){
        return countSteps(3) == 4 && countSteps(4) == 7;
    }

    static int countSteps(int n){
        int[] result = new int[n + 1];
        result[0] = 1;
        result[1] = 1;
        result[2] = 2;

        for(int i = 3; i <=n; i++){
            result[i] = result[i-1] + result[i-2] + result[i-3];
        }

        return result[n];
    }

}
