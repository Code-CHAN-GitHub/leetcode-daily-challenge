package com.leetcode.daily.y2021.m12;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;


public class d15_Q851 {


    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        boolean[][] g = new boolean[n][n];
        int[] in = new int[n];
        for (int[] r : richer) {
            g[r[0]][r[1]] = true;
            in[r[1]]++;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = i;
            if (in[i] == 0) deque.add(i);
        }
        while (!deque.isEmpty()) {
            int u = deque.poll();
            for (int v = 0; v < n; v++) {
                if (g[u][v]) {
                    if (quiet[ans[u]] < quiet[ans[v]]) ans[v] = ans[u];
                    if (--in[v] == 0) deque.add(v);
                }
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int[][] richer = {{0,5},{0,6},{0,7},{0,8},{0,9},{1,4},{1,5},{1,7},{1,8},{2,3},{2,4},{2,6},{2,8},{3,5},{3,7},{3,8},{4,6},{4,7},{4,8},{5,7},{6,7},{6,8},{7,9},{8,9}};
        int[] quiet = {5,1,9,3,8,6,7,2,0,4};
        int[] res = new d15_Q851().loudAndRich(richer, quiet);
        System.out.println(Arrays.toString(res));
    }
}