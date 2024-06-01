package com.wildfire.GoldmanSachsDsPractice.LinkedListProblems;

public class GetMiddleOfLinkedLIst {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(2);
        n1.next.next = new ListNode(3);
        n1.next.next.next = new ListNode(4);
        n1.next.next.next.next = new ListNode(5);
        n1.next.next.next.next.next = new ListNode(6);
        n1.next.next.next.next.next.next = new ListNode(7);
        n1.next.next.next.next.next.next.next = new ListNode(8);
        n1.next.next.next.next.next.next.next.next = new ListNode(9);
        System.out.println("Middle of the node is - " + getMiddle(n1).val);
    }

    private static ListNode getMiddle(ListNode head) {
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while(fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }
}
