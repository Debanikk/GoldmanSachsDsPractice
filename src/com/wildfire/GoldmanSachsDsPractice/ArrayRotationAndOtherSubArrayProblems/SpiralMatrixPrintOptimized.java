package com.wildfire.GoldmanSachsDsPractice.ArrayRotationAndOtherSubArrayProblems;

public class SpiralMatrixPrintOptimized {

    public static void main(String[] args) {
        int[][] matrix = {  { 1, 2, 3, 4, 5 },
                            { 6, 7, 8, 9, 10 },
                            { 11, 12, 13, 14, 15 },
                            { 16, 17, 18, 19, 20 } };
        int m_Row = matrix.length;
        int n_Col = matrix[0].length;
        spiralOrder(matrix, m_Row, n_Col);
    }

    static void spiralOrder(int[][] matrix, int rowLength, int colLength){
        int i =0, k=0, l=0;
        int last_row = rowLength -1, last_col = colLength -1;

        while(k <= last_row && l <= last_col){
            // print first row
            for(i = l; i<=last_col; i++){
                System.out.print(matrix[k][i] + " ");
            }
            // increment first row to next for next iteration as we don't want to print duplicate
            k++;
            //print last column
            for(i = k; i <=last_row; i++){
                System.out.print(matrix[i][last_col] + " ");
            }
            // decrement last column to last_col -1 for next iteration
            last_col--;
            // print last row and before that check k which is the row index is smaller or equals to last row or not
            if(k <= last_row){
                for(i=last_col; i>=l;i--){
                    System.out.print(matrix[last_row][i] + " ");
                }
                //decrement last row for next iteration
                last_row--;
            }
            // print first column and before that check l which is the col index is smaller or equals to last col or not
            if(l <=last_col){
                for(i=last_row; i>=k; i--){
                    System.out.print(matrix[i][l] + " ");
                }
                l++;
            }
        }
    }
}
