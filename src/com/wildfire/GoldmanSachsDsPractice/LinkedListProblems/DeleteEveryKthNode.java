package com.wildfire.GoldmanSachsDsPractice.LinkedListProblems;

import java.util.List;

public class DeleteEveryKthNode {
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
        System.out.println("Post delete");
        ListNode newHead = deleteKthNodes(head, 3);
        display(newHead);
    }

    static ListNode deleteKthNodes(ListNode head, int k) {
        if( k <= 1 || head == null)
            return null;

        ListNode current = head;
        ListNode prev = null;
        int count = 1;
        while(current != null) {
            if(count%k == 0) {
                if(prev != null) {
                    prev.next = current.next;
                }
                else {
                    head = current.next;
                }
            }
            else {
                prev = current;
            }
            current = current.next;
            count++;
        }
        return head;
    }

    static void display(ListNode head) {
        while(head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println(" ");
    }


}
