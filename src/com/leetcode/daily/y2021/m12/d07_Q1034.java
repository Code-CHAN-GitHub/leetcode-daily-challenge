package com.leetcode.daily.y2021.m12;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class d07_Q1034 {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int m = grid.length, n = grid[0].length;
        int[][] delta = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean[][] vis = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        vis[row][col] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0], y = poll[1];
            boolean flag = false;
            if (x == 0 || x == m - 1 || y == 0 || y == n - 1) 
                flag = true;
            for (int i = 0; i < delta.length; i++) {
                int xx = x + delta[i][0];
                int yy = y + delta[i][1];
                if (xx >= 0 && xx < m && yy >= 0 && yy < n && !vis[xx][yy]) {
                    if (grid[xx][yy] != grid[x][y])
                        flag = true;
                    else {
                        queue.offer(new int[]{xx, yy});
                        vis[xx][yy] = true;
                    }
                }
            }
            if (flag)
                grid[x][y] = color;
        }
        return grid;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1}, {1, 2}};
        int row = 0, col = 0, color = 3;
        int[][] res = new d07_Q1034().colorBorder(grid, row, col, color);
        for (int[] ints : res) {
            System.out.println(Arrays.toString(ints));
        }
    }
}