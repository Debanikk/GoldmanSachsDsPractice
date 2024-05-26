package com.wildfire.GoldmanSachsDsPractice.LinkedListProblems;

public class LinkedListInterSection {
    public static void main(String[] args) {

        /*ListNode headA = new ListNode(5);
        ListNode headB = new ListNode(5);

        ListNode newNode = new ListNode(6);
        headB.next = newNode;

        newNode = new ListNode(9);
        headB.next.next = newNode;

        newNode = new ListNode(15);
        headA.next = newNode;
        headB.next.next.next = newNode;

        newNode = new ListNode(30);
        headA.next.next = newNode;

        headA.next.next.next = null;*/

        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(2);
        n1.next.next = new ListNode(3);
        n1.next.next.next = new ListNode(4);
        n1.next.next.next.next = new ListNode(5);
        n1.next.next.next.next.next = new ListNode(6);
        n1.next.next.next.next.next.next = new ListNode(7);
        // list 2
        ListNode n2 = new ListNode(10);
        n2.next = new ListNode(9);
        n2.next.next = new ListNode(8);
        n2.next.next.next = n1.next.next.next;
        Print(n1);
        Print(n2);
        System.out.println("Intersection of two lists are at node - " + getIntersectionNode(n1, n2).val);

    }

    // function to print the list
    public static void Print(ListNode n)
    {
        ListNode cur = n;
        while (cur != null) {
            System.out.print(cur.val + "  ");
            cur = cur.next;
        }
        System.out.println();
    }

    private static int getListLength(ListNode head) {
        int count = 0;
        while(head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getListLength(headA);
        int lenB = getListLength(headB);

        while(lenA > lenB) {
            lenA--;
            headA = headA.next;
        }

        while(lenB > lenA) {
            lenB--;
            headB = headB.next;
        }

        while(headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }
}
