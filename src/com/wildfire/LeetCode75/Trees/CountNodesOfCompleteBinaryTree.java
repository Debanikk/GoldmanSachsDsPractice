package com.wildfire.LeetCode75.Trees;

public class CountNodesOfCompleteBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(5);
        root.left.left.right = new TreeNode(6);

        root.right = new TreeNode(7);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(9);

        System.out.println("The count of nodes in the tree is - " + countNodes(root));
    }

    private static int countNodes(TreeNode root) {
        int leftDepth = leftDepth(root);
        int rightDepth = rightDepth(root);

        if(leftDepth == rightDepth) {
            return (int)Math.pow(2, leftDepth) - 1;
        }
        else{
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }

    private static int rightDepth(TreeNode root) {
        int depth = 0;
        while(root != null) {
            root = root.right;
            depth++;
        }
        return depth;
    }

    private static int leftDepth(TreeNode root) {
        int depth = 0;
        while(root != null) {
            root = root.left;
            depth++;
        }
        return depth;
    }
}
