package com.wildfire.GoldmanSachsDsPractice.IntegerAndArrayNumberProblems;

import java.util.HashMap;

public class BestGradeAverage {

    public static void main(String[] args) {
        if (pass()) {
            System.out.println("Pass");
        } else {
            System.out.println("Some Fail");
        }
    }

    public static Boolean pass(){
        String[][] s1 = { { "Rohan", "84" }, { "Sachin", "102" }, { "Ishan", "55" }, { "Sachin", "18" } };

        return bestAvgGrade(s1) == 84;
    }

    public static Double bestAvgGrade(String[][] scores){
        double max = 0;
        HashMap<String, Student> marksheets = new HashMap<>();
        for(String[] score : scores){
            if(marksheets.containsKey(score[0])){
                marksheets.replace(score[0], new Student(marksheets.get(score[0]).count + 1,
                        (marksheets.get(score[0]).average * marksheets.get(score[0]).count + Double.parseDouble(score[1])) /
                                (marksheets.get(score[0]).count + 1)));
            }
            else{
                marksheets.put(score[0],new Student(Double.parseDouble(score[1])));
            }
        }

        for(Student s : marksheets.values()){
            if(s.average > max){
                max = s.average;
            }
        }

        return max;
    }

}

class Student{
    int count;
    double average;

    public Student(double score) {
        this.count = 1;
        this.average = score;
    }

    public Student(int count, double score){
        this.count = count;
        this.average = score;
    }
}


