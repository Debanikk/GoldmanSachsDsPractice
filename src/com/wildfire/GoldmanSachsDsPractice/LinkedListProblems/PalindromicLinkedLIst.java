package com.wildfire.GoldmanSachsDsPractice.LinkedListProblems;

public class PalindromicLinkedLIst {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(2);
        n1.next.next = new ListNode(3);
        n1.next.next.next = new ListNode(4);
        n1.next.next.next.next = new ListNode(3);
        n1.next.next.next.next.next = new ListNode(2);
        n1.next.next.next.next.next.next = new ListNode(1);
        System.out.println("Original Linked List chain");
        Print(n1);
        System.out.println("is the list palindromic - " + isPalindromicList(n1));

        //System.out.println("Reversed Linked List chain");
        //Print(reverseList(n1));
    }

    private static boolean isPalindromicList(ListNode head) {
        // this will help to find teh middle node in a Linked list
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // if the Linked list is odd sized then we have to make the left half smaller
        if(fast != null) {
            slow = slow.next;
        }
        // reverse the second half
        slow = reverseList(slow);
        fast = head;

        // start comparison for each node and return false if at any step it does not match
        while(slow != null) {
            if(fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
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

    private static ListNode reverseList(ListNode head) {
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
