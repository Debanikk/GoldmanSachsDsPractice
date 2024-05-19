package com.wildfire.LeetCode75.HashSetAndMap;

import java.util.HashMap;
import java.util.HashSet;

public class UniqueOccuranceOfIntegers {
    public static void main(String[] args) {
        int[] arr = {1,2,2,1,1,3,3};
        System.out.println("The unique Occurrence is - " + getUniqueOccurrence(arr));
    }

    private static boolean getUniqueOccurrence(int[] arr) {
        HashMap<Integer, Integer> intMap = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            if(intMap.containsKey(arr[i])) {
                intMap.put(arr[i], intMap.get(arr[i]) + 1);
            }
            else {
                intMap.put(arr[i], 1);
            }
        }
        HashSet<Integer> set = new HashSet<>();
        for(int val : intMap.keySet()) {
            if(!set.add(intMap.get(val)))
                return false;
        }
        return true;
    }
}
