package com.leetcode.daily.y2021.m12;

public class d13_Q807 {
    
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] row = new int[m];
        int[] col = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                row[i] = Math.max(row[i], grid[i][j]);
                col[j] = Math.max(col[j], grid[i][j]);
            }
        }
        int sum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum += Math.min(row[i], col[j]) - grid[i][j];
                grid[i][j] = Math.min(row[i], col[j]);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] grid = { 
            {3, 0, 8, 4}, 
            {2, 4, 5, 7},
            {9, 2, 6, 3},
            {0, 3, 1, 0} 
        };
        int res = new d13_Q807().maxIncreaseKeepingSkyline(grid);
        System.out.println(res);
    }

}