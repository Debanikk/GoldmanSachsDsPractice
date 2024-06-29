package com.wildfire.LeetCode75.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeMirror {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(7);
        System.out.println("Before mirroring - ");
        printInOrder(root);
        Mirror(root);
        System.out.println("After Mirroring - ");
        printInOrder(root);

    }
    static void Mirror(TreeNode root) {
        if(root == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(queue.size() > 0) {
            TreeNode current = queue.peek();
            queue.remove();

            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;

            if(current.left != null)
                queue.add(current.left);
            if(current.right != null)
                queue.add(current.right);
        }
    }

    static void printInOrder(TreeNode root) {
        if(root == null)
            return;
        printInOrder(root.left);
        System.out.println(root.val + " ");
        printInOrder(root.right);
    }
}
