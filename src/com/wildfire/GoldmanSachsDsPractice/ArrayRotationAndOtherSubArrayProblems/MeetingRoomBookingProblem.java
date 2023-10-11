package com.wildfire.GoldmanSachsDsPractice.ArrayRotationAndOtherSubArrayProblems;

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

        int meetingRoomRequired = getMeetingRoomRequiredCount(arr1, arr2);
        if(meetingRoomRequired > 0) {
            System.out.println("Test Passed");
            System.out.println("Meeting Room required for bookings made are - " + meetingRoomRequired);
        }
        else{
            System.out.println("Test failed as data is not correct");
        }
    }

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
}
