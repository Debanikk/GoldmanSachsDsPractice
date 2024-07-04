package com.wildfire.LeetCode75.LinkedListProblems;

public class ReverseTwoPartsWithKNodes {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(2);
        n1.next.next = new ListNode(3);
        n1.next.next.next = new ListNode(4);
        n1.next.next.next.next = new ListNode(5);
        n1.next.next.next.next.next = new ListNode(6);
        n1.next.next.next.next.next.next = new ListNode(7);

        ListNode head = reverseParts(n1, 3);
        while(head != null) {
            System.out.println(head.val + " ");
            head = head.next;
        }
    }

    static ListNode reverseParts(ListNode head, int k) {
        if(head == null || k < 0) {
            return null;
        }

        ListNode firstPart = reverse(head, k);
        ListNode current = firstPart;
        while(current.next != null && k > 1) {
            current = current.next;
            k--;
        }
        current.next = reverse(current.next, Integer.MAX_VALUE);
        head = firstPart;
        return head;
    }

    static ListNode reverse(ListNode head, int k) {
        if(head == null)
            return null;

        if(head.next == null)
            return head;

        ListNode preNode = null;
        ListNode currentNode = head;
        int count = 0;
        while(currentNode != null && count < k) {
            ListNode nextNode = currentNode.next;
            currentNode.next = preNode;
            preNode = currentNode;
            currentNode = nextNode;
            count++;
        }
        head.next = currentNode;
        return preNode;
    }
}
