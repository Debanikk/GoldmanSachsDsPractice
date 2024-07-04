package com.wildfire.LeetCode75.LinkedListProblems;

public class LinkedListDriver {

    public static void main(String[] args) {
        CustomLinkedList llist = new CustomLinkedList();
        llist.push(7);
        llist.push(10);
        llist.push(19);
        llist.push(4);
        llist.push(74);
        llist.push(26);
        llist.push(59);

        System.out.println("Created Linked List is - ");
        llist.printList();

        llist.deleteNthNode(5);

        System.out.println("Linked List after deleting 5th index is - ");
        llist.printList();
    }
}
