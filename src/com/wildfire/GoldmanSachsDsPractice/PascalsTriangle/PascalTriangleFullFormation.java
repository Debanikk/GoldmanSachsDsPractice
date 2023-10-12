package com.wildfire.GoldmanSachsDsPractice.PascalsTriangle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PascalTriangleFullFormation {
    public static void main(String[] args) {
        System.out.println("Enter the level of Pascal's triangle you want to create");
        Scanner scanner = new Scanner(System.in);
        int val = scanner.nextInt();
        List<List<Integer>> result = pascalsTriangleWithList(val);
        for(List<Integer> level: result) {
            for(Integer i : level) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
        System.out.println("");
        System.out.println("List Method ends here");
        System.out.println("Array Method Begins here");
        System.out.println("");

        int[][] arrRes = pascalsTriangleWithArray(val);
        for(int i = 0; i < val; i++) {
            for(int j = 0; j <= i; j++) {
                System.out.print(arrRes[i][j] + " ");
            }
            System.out.println("");
        }

    }

    static List<List<Integer>> pascalsTriangleWithList(int num) {
        List<List<Integer>> result = new ArrayList<>();
        if(num == 0)
            return result;

        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        result.add(firstRow);

        for(int i = 1; i < num; i++) {
            List<Integer> prevRow = result.get(i-1);
            List<Integer> currRow = new ArrayList<>();
            currRow.add(1);
            for(int j =1; j < i; j++) {
                currRow.add(prevRow.get(j-1) + prevRow.get(j));
            }
            currRow.add(1);
            result.add(currRow);
        }
        return result;
    }

    static int[][] pascalsTriangleWithArray(int num) {
        int[][] result = new int[num][num];
        for(int line = 0; line< num; line++) {
            for(int i = 0; i <=line; i++) {
                if(line == 1 || i == 0) {
                    result[line][i] = 1;
                    System.out.print(result[line][i] + " ");
                }
                else{
                    result[line][i] = result[line - 1][i - 1] + result[line - 1][i];
                    System.out.print(result[line][i] + " ");
                }
            }
            System.out.println("");
        }
        System.out.println("Printed from method");
        System.out.println("");
        return result;
    }
}
