package com.wildfire.LeetCode75.ArrayAndStrings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DifferenceOfTwoArrays {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,3};
        int[] arr2 = {1,1,2,2};
        //System.out.println(findDifference(arr1, arr2));
        System.out.println(findDifferenceAlternate(arr1, arr2));
    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(getDistinctValues(nums1, nums2));
        result.add(getDistinctValues(nums2, nums1));
        return result;
    }

    public static List<Integer> getDistinctValues(int[] nums1, int[] nums2) {
        List<List<Integer>> resultList = new ArrayList<>();
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for(int num : nums2) {
            set2.add(num);
        }

        for(int num : nums1) {
            if(!set2.contains(num))
                set1.add(num);
        }
        return new ArrayList<>(set1);
    }

    public static List<List<Integer>> findDifferenceAlternate(int[] nums1, int[] nums2) {
        Set<Integer> set_1 = new HashSet<>();
        Set<Integer> set_2 = new HashSet<>();

        for(int i=0; i<nums1.length; i++){
            set_1.add(nums1[i]);
        }

        for(int i=0; i<nums2.length; i++){
            set_2.add(nums2[i]);
        }

        List<Integer> distinct1 = new ArrayList<>();
        for(Integer n: set_1){
            if (!set_2.contains(n)){
                distinct1.add(n);
            }
        }

        List<Integer> distinct2 = new ArrayList<>();
        for(Integer n: set_2){
            if (!set_1.contains(n)){
                distinct2.add(n);
            }
        }

        List<List<Integer>> output = new ArrayList<>();
        output.add(distinct1);
        output.add(distinct2);

        return output;
    }
}
