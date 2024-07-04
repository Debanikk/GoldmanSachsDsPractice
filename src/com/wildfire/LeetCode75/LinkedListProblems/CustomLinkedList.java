package com.wildfire.LeetCode75.LinkedListProblems;

public class CustomLinkedList {
    ListNode head;

    // Delete nth Node from a given linkedList
    ListNode deleteNthNode(int dIndex) {
        int len = 0;
        ListNode temp = head;

        while(temp != null) {
            len++;
            temp = temp.next;
        }

        if(dIndex > len) {
            return head;
        }
        else if (dIndex == len) {
            return head.next;
        }
        else {
            ListNode prev = null;
            ListNode curr = head;
            for(int i = 0; i < dIndex; i++) {
                prev = curr;
                curr = curr.next;
            }
            prev.next = curr.next;
            return head;
        }
    }

    /// adds node at the front of the linkedList, this will shift the head to newly added node
    public void push(int data) {
        ListNode newNode = new ListNode(data);
        newNode.next = head;
        head = newNode;
    }

    public void printList() {
        ListNode tNode = head;
        while(tNode != null) {
            System.out.println(tNode.val + " ");
            tNode = tNode.next;
        }
    }
}
