package com.wildfire.GoldmanSachsDsPractice.LinkedListProblems;

public class ReverseLinkedLIst {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(2);
        n1.next.next = new ListNode(3);
        n1.next.next.next = new ListNode(4);
        n1.next.next.next.next = new ListNode(5);
        n1.next.next.next.next.next = new ListNode(6);
        n1.next.next.next.next.next.next = new ListNode(7);
        System.out.println("Original Linked List chain");
        Print(n1);
        System.out.println("Reversed Linked List chain");
        Print(reverseWithoutExtraSpace(n1));

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

    private static ListNode reverseWithoutExtraSpace(ListNode head) {
        if(head == null)
            return null;

        if(head.next == null)
            return head;

        ListNode preNode = null;
        ListNode currentNode = head;
        while(currentNode != null) {
            ListNode nextNode = currentNode.next;
            currentNode.next = preNode;
            preNode = currentNode;;
            currentNode = nextNode;
        }

        head = preNode;
        return head;
    }
}
