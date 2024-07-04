package com.wildfire.LeetCode75.LinkedListProblems;

public class ReOrderList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);


        System.out.println("The original linked list is - ");
        ListNode displayHead = head;
        display(displayHead);
        System.out.println("The re-ordered list is - " );
        getReOrderedList(head);
        display(head);
    }

    static void getReOrderedList(ListNode head) {
        // check edge cases
        if(head == null || head.next == null)
            return;

        // get middle element of the list using slow and fast pointers
        ListNode slow = head;
        ListNode fast = head;
        while(slow.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //  Now reverse the last part of the list starting after the middle Node
        //  and the last element should be the next element to the middle Node

        ListNode preMiddle = slow;
        ListNode preCurrent = slow.next;
        while (preCurrent.next != null) {
            ListNode current = preCurrent.next;
            preCurrent.next = current.next;
            current.next = preMiddle.next;
            preMiddle.next = current;
        }

        // Next part is to reorder the list in our desired format like 1 -> n -> 2 -> n-1 -> 3 -> n-2 -> null
        slow = head;
        fast = preMiddle.next;
        while(slow != preMiddle) {
            preMiddle.next = fast.next;
            fast.next = slow.next;
            slow.next = fast;
            slow = fast.next;
            fast = preMiddle.next;
        }
    }

    static void display(ListNode head) {
        while(head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println(" ");
    }
}
