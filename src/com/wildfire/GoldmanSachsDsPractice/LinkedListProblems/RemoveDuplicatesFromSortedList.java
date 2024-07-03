package com.wildfire.GoldmanSachsDsPractice.LinkedListProblems;

public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(2);
        n1.next.next = new ListNode(2);
        n1.next.next.next = new ListNode(4);
        n1.next.next.next.next = new ListNode(5);
        n1.next.next.next.next.next = new ListNode(5);
        n1.next.next.next.next.next.next = new ListNode(5);
        System.out.println("Original Linked List chain");
        Print(n1);
        System.out.println("after removing duplicates the new Linked List");
        Print(removeDuplicates(n1));
    }

    static ListNode removeDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode prev = head;
        ListNode temp = prev.next;
        while(temp != null) {
            if(temp.val == prev.val) {
                temp = temp.next;
                continue;
            }
            prev.next = temp;
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        return head;
    }

    public static void Print(ListNode n)
    {
        ListNode cur = n;
        while (cur != null) {
            System.out.print(cur.val + " -> ");
            cur = cur.next;
        }
        System.out.println("null");
        System.out.println();
    }
}
