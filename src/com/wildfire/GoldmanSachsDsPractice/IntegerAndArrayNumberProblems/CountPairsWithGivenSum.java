package com.wildfire.GoldmanSachsDsPractice.IntegerAndArrayNumberProblems;

import java.util.HashMap;

public class CountPairsWithGivenSum {
    public static void main(String[] args) {


        if(DoTests()){
            System.out.println("Test results are successful");
        }
        else{
            System.out.println("Test results failed");
        }
    }

    static Boolean DoTests(){
        int arr[] = {1, 5, 7, -1, 5};
        int n = arr.length;
        int sum = 6;

        getPairsCountFiltered(arr, sum);
        int result = getPairsCount(arr, n, sum);
        System.out.println("Count of pairs is - " + result);
        return result == 3;
    }

    static int getPairsCount(int[] arr, int len, int targetSum){
        if(len < 2)
            return -1;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < len; i++){
            if(map.containsKey(targetSum - arr[i])){
                count += map.get(targetSum - arr[i]);
            }
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i] + 1));
            }
            else{
                map.put(arr[i], 1);
            }
        }
        return count;
    }

    static void getPairsCountFiltered(int[] arr, int targetSum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; ++i) {
            int temp = targetSum - arr[i];
            if(map.containsKey(temp)) {
                System.out.println("array index are - " + i + " and - " + map.get(temp));
            }
            map.put(arr[i], i);
        }
    }
}
