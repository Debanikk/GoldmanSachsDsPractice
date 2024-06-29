package com.wildfire.LeetCode75.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class IdenticalTree {
    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(3);
        tree1.left.left = new TreeNode(4);
        tree1.left.right = new TreeNode(5);

        // Create the second binary tree
        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(2);
        tree2.right = new TreeNode(3);
        tree2.left.left = new TreeNode(4);
        tree2.left.right = new TreeNode(5);

        // Create the BinaryTree object and check if trees are equal
        boolean result = isIdentical(tree1, tree2);
        // Print the result
        System.out.println("Are the two binary trees equal? " + result);
    }

    static boolean isIdentical(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null)
            return true;

        if(root1 == null || root2 == null) {
            return false;
        }

        return (root1.val == root2.val) && isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);

    }
}
