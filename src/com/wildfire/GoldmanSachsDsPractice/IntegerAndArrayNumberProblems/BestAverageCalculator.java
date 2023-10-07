package com.wildfire.GoldmanSachsDsPractice.IntegerAndArrayNumberProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestAverageCalculator {
    public static void main(String[] args){
        String[][] scores = {{"Bob","85"},{"Mark","100"},{"Charles","63"},{"Mark","34"}};
        System.out.println("best Average is: " + bestAverageCalc(scores));
    }

    //Find the best average in a 2d Array
    static int bestAverageCalc(String[][] scores) {
        //Create Hashmap to map student name and their scores
        Map<String, List<Integer>> scoreMap = new HashMap<String, List<Integer>>();
        for(String[] score: scores){
            String studentName = score[0];
            int currentScore = Integer.parseInt(score[1]);

            List<Integer> scoreList;
            if(scoreMap.containsKey(studentName)){
                scoreList = scoreMap.get(studentName);
                scoreList.add(currentScore);
            }
            else{
                scoreList = new ArrayList<>();
                scoreList.add(currentScore);
            }
            scoreMap.put(studentName, scoreList);
        }

        int bestAverage = 0;

        // HashMap is formed, now we need to iterate and
        // find the best average for acquired scores of the students
        for(List<Integer> value: scoreMap.values()){
            int sum = 0;
            int count = 0;
            for(int i: value){
                sum += i;
                count++;
            }
            int average = (int)Math.floor(sum/count);
            bestAverage = (average > bestAverage) ? average : bestAverage;
        }

        return bestAverage;
    }
}
