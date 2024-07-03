package com.wildfire.GoldmanSachsDsPractice.LinkedListProblems;

public class ReversePrintLinkedLIst {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(2);
        n1.next.next = new ListNode(3);
        n1.next.next.next = new ListNode(4);
        n1.next.next.next.next = new ListNode(5);
        n1.next.next.next.next.next = new ListNode(6);
        n1.next.next.next.next.next.next = new ListNode(7);
        n1.next.next.next.next.next.next.next = new ListNode(8);

        reversePrintList(n1);
    }

    private static void reversePrintList(ListNode head) {
        if(head == null)
            return;

        reversePrintList(head.next);
        System.out.println("The value of current node is - " + head.val);
    }
}
