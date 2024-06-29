package com.wildfire.GoldmanSachsDsPractice.LinkedListProblems;

public class KthFromLastNode {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        System.out.println("The kth Node from last is - " + getKthFromLast(head, 8));
    }

    static int getKthFromLast(ListNode head, int k) {
        if(head == null)
            return -1;
        if(head.next == null && k > 1)
            return -1;
        ListNode leftPtr = head;
        ListNode rightPtr = head;
        int counter = 0;
        while(counter < k) {
            if(rightPtr == null)
                return -1;
            rightPtr = rightPtr.next;
            counter++;
        }

        while(rightPtr != null) {
            leftPtr = leftPtr.next;
            rightPtr = rightPtr.next;
        }

        return leftPtr.val;
    }
}
