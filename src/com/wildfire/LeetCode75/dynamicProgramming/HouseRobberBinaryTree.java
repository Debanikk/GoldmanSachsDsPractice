package com.wildfire.LeetCode75.dynamicProgramming;

import com.wildfire.LeetCode75.Trees.TreeNode;

public class HouseRobberBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(7);

        System.out.println("The maximum money that can be robbed is - " + rob(root));
    }

    private static int rob(TreeNode root) {
        int[] options = travelHousesAndRob(root);
        return Math.max(options[0], options[1]);
    }

    private static int[] travelHousesAndRob(TreeNode root) {
        if (root == null)
            return new int[2];

        int[] left_node_choices = travelHousesAndRob(root.left);
        int[] right_node_choices = travelHousesAndRob(root.right);
        int[] options = new int[2];

        // Store value if looted in [0]
        options[0] = root.val + left_node_choices[1] + right_node_choices[1];

        // Store value if skipped in [1]
        options[1] = Math.max(left_node_choices[0], left_node_choices[1]) + Math.max(right_node_choices[0], right_node_choices[1]);
        return options;
    }
}
