package com.wildfire.GoldmanSachsDsPractice.PermutationAndCombination;

import java.util.ArrayList;
import java.util.List;

/// Given a set of numbers identify pairs such that a^b = b^a

public class AllCombinationOfSizeRInNSizeArray {
    static List<List<Integer>> setList = new ArrayList<>();
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6};
        int r = 2;
        int len = arr.length;
        printCombination(arr, len, r);
        System.out.println(setList);
        checkCondition(setList);
    }

    // This method checks the
    static void checkCondition(List<List<Integer>> myList){
        int count = 0;
        for(List<Integer> set : myList){
            /*System.out.println("Set numbers are - ");
            System.out.println(set.get(0));
            System.out.println(set.get(1));*/
            if(Math.pow(set.get(0), set.get(1)) == Math.pow(set.get(1), set.get(0))){
                count++;
                System.out.println("final result is: " + set.get(0) + " " + set.get(1));
            }
        }
    }

    static void printCombination(int arr[], int len, int r){
        int data[] = new int[r];
        combinationUtil(arr, len, r, 0, data, 0);
    }

    static void combinationUtil(int arr[], int len, int r, int index, int data[], int i){
        if(index == r){
            List<Integer> lst = new ArrayList<>();
            for(int j=0; j<r; j++){
                System.out.print(data[j] + " ");
                lst.add(data[j]);
            }
            setList.add(lst);
            System.out.println("");
            return;
        }
        if(i >=len)
            return;

        data[index] = arr[i];
        combinationUtil(arr, len, r, index+1, data, i+1);

        combinationUtil(arr, len, r, index, data, i+1);
    }
}
