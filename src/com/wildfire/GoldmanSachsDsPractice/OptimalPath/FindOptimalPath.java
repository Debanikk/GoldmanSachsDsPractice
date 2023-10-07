package com.wildfire.GoldmanSachsDsPractice.OptimalPath;

public class FindOptimalPath {
    public static void main(String[] args) {
        if (doTestsPass()) {
            System.out.println("All tests pass");
        } else {
            System.out.println("Tests fail.");
        }
    }

    public static boolean doTestsPass() {
        boolean result = true;
        result &= optimalPath(new Integer[][] { { 0, 0, 0, 0, 5 }, { 0, 1, 1, 1, 0 }, { 2, 0, 0, 0, 0 } }) == 10;
        return result;
    }

    public static Integer optimalPath(Integer[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int[][] gridValue = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                gridValue[i][j] = -1;
            }
        }
        optimalPathFinder(grid, grid.length - 1, 0, gridValue);
//		System.out.println(gridValue[0][grid[0].length - 1]);
        return gridValue[grid.length - 1][0];
//		return 0;
    }

    public static void optimalPathFinder(Integer[][] grid, int row, int col, int[][] gridValue) {
        int val = 0;
        System.out.println(row + " " + col);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (row == 0 && col == 0) {
            gridValue[0][0] = grid[0][0];
            return;
        }
        if (row > 0) {
            if (gridValue[row - 1][col] == -1) {
                optimalPathFinder(grid, row - 1, col, gridValue);
            }
            val = gridValue[row - 1][col];
        }
        if (col < grid[0].length - 1) {
            if (gridValue[row][col + 1] == -1) {
                optimalPathFinder(grid, row, col + 1, gridValue);
            }
            val = Math.max(val, gridValue[row][col + 1]);
            // if(val < gridValue[row][col-1]) {
            // val = gridValue[row][col-1]
            // }
        }
        gridValue[row][col] = grid[row][col] + val;
		System.out.println(val + " " + grid[row][col] + " " + gridValue[row][col]);
        return;
    }
}
