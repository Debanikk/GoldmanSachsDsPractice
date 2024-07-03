package com.wildfire.LeetCode75.MergeIntervals;

import java.util.Arrays;

public class MinimumArrowsToBurstBalloons {
    public static void main(String[] args) {
        int[][] arr = {{10,16},{2,8},{1,6},{7,12}};
        System.out.println("The number of balloons required is - " + minArrows(arr));
    }

    static int minArrows(int[][] ballons) {
        Arrays.sort(ballons, (a,b) -> Integer.compare(a[1], b[1]));
        int end = ballons[0][1];
        int arrows = 1;
        for(int i = 1; i< ballons.length; i++) {
            if(ballons[i][0] <= end) {
                continue;
            }
            else {
                end = ballons[i][1];
                arrows++;
            }
        }
        return arrows;
    }
}
