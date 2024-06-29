package com.wildfire.LeetCode75.Trees;

public class ChildrenSumEqualsToRoot {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(35);
        root.left = new TreeNode(20);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(15);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("The sum property is - " + isSumProperty(root));
    }

    static int isSumProperty(TreeNode root) {
        if(root == null || (root.left == null && root.right == null))
            return 1;
        int left_value, right_value;
        left_value = root.left == null ? 0 : root.left.val;
        right_value = root.right == null ? 0 : root.right.val;

        if (root.val == left_value + right_value) {
            int leftSum = isSumProperty(root.left);
            int rightSum = isSumProperty(root.right);
            if(leftSum == 1 && rightSum == 1) {
                return 1;
            }
        }
        return 0;
    }
}
