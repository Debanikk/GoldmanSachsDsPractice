package com.wildfire.GoldmanSachsDsPractice.OptimalPath;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomProblem {
    public static void main(String[] args) {
        int[][] meetings = {{6,8}, {4,6}, {3,5}, {8,9}};
        int roomRequired = minMeetingRooms(meetings);
        System.out.println("Meeting room required is - " + roomRequired);
    }

    private static int minMeetingRooms(int[][] meetings) {
        if (meetings.length == 0) {
            return 0;
        }

        // Sort meetings in ascending order by start time
        // also comparison can be done this way - Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        // Initialize heap and add the end time of the first meeting
        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        rooms.add(meetings[0][1]);

        for (int i = 1; i < meetings.length; i++) {
            int start = meetings[i][0];
            int end = meetings[i][1];

            // If the earliest ending meeting ends before the next meeting starts,
            // remove it from the heap
            if (rooms.peek() <= start) {
                rooms.poll();
            }

            // Add the current meeting's end time to the heap
            rooms.add(end);
        }

        // The size of the heap at the end is the minimum rooms required
        return rooms.size();
    }
}
