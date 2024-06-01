package com.wildfire.GoldmanSachsDsPractice.LinkedListProblems;

public class LinkedListCycle {
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
        n1.next.next.next.next.next.next.next.next.next = n1.next.next;

        System.out.println("Cycle starts at node - " + detectCycle(n1).val);

    }

    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;

        // advance both node at different speed until they meet once
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            // As soon as they meet, start from the head again
            // and move at the same speed this time.
            if(slow == fast) {
                while(head != slow) {
                    head = head.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
