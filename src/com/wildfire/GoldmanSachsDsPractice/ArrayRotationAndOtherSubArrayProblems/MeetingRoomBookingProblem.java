package com.wildfire.GoldmanSachsDsPractice.ArrayRotationAndOtherSubArrayProblems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*****************************
 * Given two array a1[] = {1, 9, 3, 7, 6, 10} and a2[] = {3, 10, 5, 9, 7, 11}
 * are the respective start and end times that have been requested by employees
 * for meeting room bookings. Based on the above two arrays decide how many meeting
 * rooms are required in order to accommodate all meetings for employees.
 * **************************/


public class MeetingRoomBookingProblem {
    public static void main(String[] args) {
        int[] arr1 = {1, 9, 3, 7, 6, 10};
        int[] arr2 = {3, 10, 5, 9, 7, 11};

        int roomReq = minMeetingRooms(arr1, arr2);
        System.out.println(roomReq);

        int meetingRoomRequired = getMeetingRoomRequiredCount(arr1, arr2);
        if(meetingRoomRequired > 0) {
            System.out.println("Test Passed");
            System.out.println("Meeting Room required for bookings made are - " + meetingRoomRequired);
        }
        else{
            System.out.println("Test failed as data is not correct");
        }
    }

    // Brute force approach
    // For better approach go to OptimalPath package and
    // The solution file name is - MeetingRoomProblem.java
    static int getMeetingRoomRequiredCount(int[] arr1, int[] arr2) {
        int count = 1;
        if(arr1.length != arr2.length){
            return -1;
        }
        if(arr1.length < 1) {
            return -1;
        }

        int arrLen = arr1.length;
        for(int i = 0; i < arrLen; i++) {
            for(int j = i + 1; j < arrLen; j++) {
                if((arr1[j] <= arr2[i]) && (arr1[j] > arr1[i])) {
                    count++;
                }
            }
        }
        return count;
    }

    // optimal solution
    private static int minMeetingRooms(int[] meetingStart, int[] meetingEnd) {
        if (meetingStart.length != meetingEnd.length && meetingStart.length == 0) {
            return 0;
        }

        int[][] meetings = new int[meetingStart.length][2];

        for(int i = 0; i < meetingStart.length; i++) {
            meetings[i][0] = meetingStart[i];
            meetings[i][1] = meetingEnd[i];
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
