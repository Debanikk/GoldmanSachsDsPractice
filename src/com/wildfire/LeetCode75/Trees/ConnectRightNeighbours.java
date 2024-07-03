package com.wildfire.LeetCode75.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectRightNeighbours {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        connect(root);
        printLevels(root);
    }

    public static void connect(TreeNode root) {
        if(root == null)
            return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            TreeNode previous = null;
            for(int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if(previous != null) {
                    previous.next = current;
                }
                previous = current;
                if(current.left != null) {
                    queue.add(current.left);
                }
                if(current.right != null) {
                    queue.add(current.right);
                }
            }
        }
    }

    public static void printLevels(TreeNode root) {
        TreeNode levelRoot = root;
        while(levelRoot != null) {
            TreeNode current = levelRoot;
            while(current != null) {
                System.out.print(current.val + " ");
                current = current.next;
            }
            System.out.println();
            levelRoot = levelRoot.left;
        }
    }
}
