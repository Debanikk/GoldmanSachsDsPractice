package com.wildfire.LeetCode75.PriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueHandlingWithEnum {
    // Define an enum for the priorities
    enum Priority {
        HIGH, MEDIUM, LOW
    }

    public static void main(String[] args) {
        // Create a comparator that orders strings based on the priority enum
        Comparator<String> priorityComparator = Comparator.comparingInt(s -> {
            switch (s) {
                case "HIGH":
                    return 1;
                case "MEDIUM":
                    return 2;
                case "LOW":
                    return 3;
                default:
                    throw new IllegalArgumentException("Unknown priority: " + s);
            }
        });

        // Create a PriorityQueue with the custom comparator
        PriorityQueue<String> stringHeap = new PriorityQueue<>(priorityComparator);

        // Add some strings to the priority queue
        stringHeap.add(Priority.LOW.toString());
        stringHeap.add(Priority.HIGH.toString());
        stringHeap.add(Priority.MEDIUM.toString());
        stringHeap.add(Priority.HIGH.toString());
        stringHeap.add(Priority.LOW.toString());
        stringHeap.add(Priority.MEDIUM.toString());

        // Poll elements from the priority queue
        while (!stringHeap.isEmpty()) {
            System.out.println(stringHeap.poll());
        }
    }

}
