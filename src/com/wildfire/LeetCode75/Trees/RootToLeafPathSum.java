package com.wildfire.LeetCode75.Trees;

public class RootToLeafPathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        System.out.println("The result is - " + hasPathSum(root, 9));
    }

    static boolean hasPathSum(TreeNode root, int sum) {
        if(root.val > sum)
            return false;
        /* If the tree is empty there is no way the read sum
         * will be there. */
        if (root == null)
            return false;
        boolean ans = false;
        int subSum = sum - root.val;
        if (subSum == 0 && root.left == null
                && root.right == null)
            return (ans = true);
        if (root.left != null)

            // ans || hasPathSum... has no utility if the
            // ans is false
            ans = ans || hasPathSum(root.left, subSum);

        if (root.right != null)

            // But if it is true then we can avoid calling
            // hasPathSum here as answer has already been
            // found
            ans = ans || hasPathSum(root.right, subSum);
        return (ans);
    }
}
