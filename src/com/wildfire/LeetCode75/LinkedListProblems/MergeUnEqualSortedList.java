package com.wildfire.LeetCode75.LinkedListProblems;

public class MergeUnEqualSortedList {
    public static void main(String[] args) {
// List 1: 1 -> 3 -> 5
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(5);

        // List 2: 2 -> 4 -> 6
        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(4);
        head2.next.next = new ListNode(6);

        ListNode mergedHead = getMergedListInDescendingOrder(head1, head2);
        System.out.println("Merged list in non-increasing order:");
        printList(mergedHead);
    }

    public static ListNode getMergedListInDescendingOrder(ListNode head1, ListNode head2) {
        ListNode mergedHead = null;
        while(head1 != null && head2 != null) {
            if(head1.val <= head2.val) {
                ListNode nextNode = head1.next;
                head1.next = mergedHead;
                mergedHead = head1;
                head1 = nextNode;
            }
            else {
                ListNode nextNode = head2.next;
                head2.next = mergedHead;
                mergedHead = head2;
                head2 = nextNode;

            }
        }

        // add remaining nodes from list1
        while(head1 != null) {
            ListNode nextNode = head1.next;
            head1.next = mergedHead;
            mergedHead = head1;
            head1 = nextNode;
        }

        // add remaining nodes from list2
        while(head2 != null) {
            ListNode nextNode = head2.next;
            head2.next = mergedHead;
            mergedHead = head2;
            head2 = nextNode;
        }
        return mergedHead;
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}
