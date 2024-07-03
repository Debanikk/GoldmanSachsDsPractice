package com.wildfire.LeetCode75.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class SumOfLeafNodesAtMinLevel {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);

        int sum = getSumOfLeafNodesAtMinimumLevel(root);
        System.out.println("Sum of leaf nodes at minimum level: " + sum);
    }

    public static int getSumOfLeafNodesAtMinimumLevel(TreeNode root) {
        if(root == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int sum = 0;
        boolean isLeafNode = false;

        while(!queue.isEmpty() && !isLeafNode) {
            int size = queue.size();
            sum = 0;

            for(int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                if(current.left == null && current.right == null) {
                    sum += current.val;
                    isLeafNode = true;
                }

                if(current.left != null) {
                    queue.add(current.left);
                }

                if(current.right != null) {
                    queue.add(current.right);
                }
            }
        }
        return sum;
    }
}
