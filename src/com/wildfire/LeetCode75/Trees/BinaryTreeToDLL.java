package com.wildfire.LeetCode75.Trees;

public class BinaryTreeToDLL {
    static TreeNode head;
    static TreeNode previous = null;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(12);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(25);
        root.left.right = new TreeNode(30);
        root.right.left = new TreeNode(36);

        convertToDLL(root);
        printDLL(head);
    }

    static void convertToDLL(TreeNode root) {
        if(root == null) {
            return;
        }

        //recursively fix left subtree
        convertToDLL(root.left);
        // convert current node
        if(previous == null) {
            // this is the leftmost node, set it as head of doubly linked list
            head = root;
        }
        else {
            // adjust the pointers
            root.left = previous;
            previous.right = root;
        }
        //mark this node as previous node for the next call
        previous = root;
        // recursively convert the right subtree
        convertToDLL(root.right);
    }

    // Function to print the doubly linked list
    public static void printDLL(TreeNode head) {
        TreeNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.right;
        }
        System.out.println();
    }

}
