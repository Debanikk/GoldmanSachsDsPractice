package com.wildfire.GoldmanSachsDsPractice.LinkedListProblems;

public class DeleteKthNodeFromLast {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        System.out.println("The original linked list is - ");
        ListNode displayHead = head;
        display(displayHead);
        System.out.println("Post delete");
        deleteKthFromLast(head, 4);
        display(displayHead);
    }

    static void display(ListNode head) {
        while(head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println(" ");
    }

    static void deleteKthFromLast(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;

        for(int i = 0; i < k; i++) {
            fast = fast.next;
        }
        if(fast == null) {
            head = head.next;
            return;
        }
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return;
    }
}
