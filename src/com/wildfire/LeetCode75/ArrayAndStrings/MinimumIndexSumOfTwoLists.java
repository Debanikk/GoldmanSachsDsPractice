package com.wildfire.LeetCode75.ArrayAndStrings;

import java.util.*;

/** Given two arrays of strings list1 and list2, find the common strings with the least index sum.

 A common string is a string that appeared in both list1 and list2.

 A common string with the least index sum is a common string such that if it appeared at list1[i] and list2[j] then i + j should be the minimum value among all the other common strings.

 Return all the common strings with the least index sum. Return the answer in any order. **/
public class MinimumIndexSumOfTwoLists {
    public static void main(String[] args) {
        String[] list1 = {"Shogun","Tapioca Express","Burger King","KFC"};
        String[] list2 = {"KFC","Shogun","Burger King"};
        String[] result = findRestaurant(list1, list2);
        for(int i = 0; i < result.length; i++) {
            System.out.println("restaurant with shortest distance is - " + result[i]);
        }
    }

    private static String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();

        int maxSum = Integer.MAX_VALUE;
        for(int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        for(int i = 0; i < list2.length; i++) {
            if(map.containsKey(list2[i])) {
                int currentSum = map.get(list2[i]) + i;
                if(currentSum < maxSum) {
                    result.clear();
                    result.add(list2[i]);
                    maxSum = currentSum;
                }
                else if(currentSum == maxSum) {
                    result.add(list2[i]);
                }
            }
        }
        return result.toArray(new String[result.size()]);
    }

    public String[] findRestaurantOptimum(String[] list1, String[] list2) {
        if(list1.length > list2.length) { return findRestaurantOptimum(list2, list1); }
        Map<String, Integer> l1Map = new HashMap<>();
        int min = Integer.MAX_VALUE;

        for(int index = 0; index < list1.length; index++) {
            l1Map.put(list1[index], index);
        }

        int distance;
        List<String> list = new ArrayList<>();
        for(int index = 0; index < list2.length && index <= min; index++) {
            if(l1Map.containsKey(list2[index])) {
                distance = index + l1Map.get(list2[index]);
                if(distance < min) {
                    min = distance;
                    list.clear();
                    list.add(list2[index]);
                } else if(distance == min) {
                    list.add(list2[index]);
                }
            }
        }
        return list.toArray(new String[list.size()]);
    }
}
