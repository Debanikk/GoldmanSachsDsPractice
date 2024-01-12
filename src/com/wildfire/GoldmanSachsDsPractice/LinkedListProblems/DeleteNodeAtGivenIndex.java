package com.wildfire.GoldmanSachsDsPractice.LinkedListProblems;

public class DeleteNodeAtGivenIndex {
    Node head;

    class Node {
        int value;
        Node next;
        public Node(int data) {
            this.value = data;
            this.next = null;
        }
    }

    // Delete nth Node from a given linkedList
    Node deleteNthNode(int dIndex) {
        int len = 0;
        Node temp = head;

        while(temp != null) {
            len++;
            temp = temp.next;
        }

        if(dIndex > len) {
            return head;
        }
        else if (dIndex == len) {
            return head.next;
        }
        else {
            Node prev = null;
            Node curr = head;
            for(int i = 0; i < dIndex; i++) {
                prev = curr;
                curr = curr.next;
            }
            prev.next = curr.next;
            return head;
        }
    }

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void printList() {
        Node tNode = head;
        while(tNode != null) {
            System.out.println(tNode.value + " ");
            tNode = tNode.next;
        }
    }

    public static void main(String[] args) {
        DeleteNodeAtGivenIndex llist = new DeleteNodeAtGivenIndex();
        llist.push(7);
        llist.push(10);
        llist.push(19);
        llist.push(4);
        llist.push(74);
        llist.push(26);
        llist.push(59);

        System.out.println("Created Linked List is - ");
        llist.printList();

        llist.deleteNthNode(5);

        System.out.println("Linked List after deleting 5th index is - ");
        llist.printList();
    }
}
