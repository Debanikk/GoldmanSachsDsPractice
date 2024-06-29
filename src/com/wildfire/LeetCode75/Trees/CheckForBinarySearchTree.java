package com.wildfire.LeetCode75.Trees;

public class CheckForBinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        // Function call
        if (isBST(root))
            System.out.println("Is BST");
        else
            System.out.println("Not a BST");
    }

    public static boolean isBST(TreeNode root) {
        return isBSTRecursiveCheck(root);
    }

    static TreeNode previous;

    private static boolean isBSTRecursiveCheck(TreeNode root) {
        if(root != null) {
            if(!isBSTRecursiveCheck(root.left))
                return false;

            if(previous != null && root.val <= previous.val)
                return false;

            previous = root;
            return isBSTRecursiveCheck(root.right);
        }
        return true;
    }
}
