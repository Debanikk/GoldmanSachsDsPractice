package com.wildfire.GoldmanSachsDsPractice.PermutationAndCombination;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniquePermutation {
    public static void main(String[] args) {
        int[] nums = {1,1,3};
        List<List<Integer>> resultList = permuteUnique(nums);
        for(List<Integer> lst : resultList) {
            System.out.println(lst);
        }
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>(); //final result to store all the unique list
        List<Integer> permutation = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        helper(nums, permutation, res, visited, 0);
        return res;
    }

    public static void helper(int[] nums, List<Integer> permutation, List<List<Integer>> res, Set<Integer> visited, int currentIndex) {
        if(visited.size() == nums.length) {
            res.add(new ArrayList<>(permutation));
            return;
        }
        for(int i = currentIndex; i < nums.length; i++) {
            if(!visited.contains(nums[i])) {
                permutation.add(nums[i]);
                visited.add(nums[i]);
                helper(nums, permutation, res, visited, currentIndex);
                permutation.remove(permutation.size() - 1);
                visited.remove(nums[i]);
            }
        }
    }
}
