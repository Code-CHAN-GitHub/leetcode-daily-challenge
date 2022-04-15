package com.leetcode.collect.N皇后;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collect_Q51 {

    List<List<String>> ans = new ArrayList<>();
    char[][] mp;
    boolean[] vis1;
    boolean[] vis2;
    boolean[] vis3;
    
    public List<List<String>> solveNQueens(int n) {
        mp = new char[n][n];
        vis1 = new boolean[n];
        vis2 = new boolean[2 * n - 1];
        vis3 = new boolean[2 * n - 1];
        for (int i = 0; i < n; i++)
            Arrays.fill(mp[i], '.');
        dfs(0);
        return ans;
    }
    
    private void dfs(int row) {
        int n = mp.length;
        if (row == n) {
            List<String> tmp = new ArrayList<>();
            for (char[] chars : mp) tmp.add(String.valueOf(chars));
            ans.add(tmp);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!vis1[i] && !vis2[i - row + n - 1] && !vis3[i + row]) {
                mp[row][i] = 'Q';
                vis1[i] = true;
                vis2[i - row + n - 1] = true;
                vis3[i + row] = true;
                dfs(row + 1);
                vis1[i] = false;
                vis2[i - row + n - 1] = false;
                vis3[i + row] = false;
                mp[row][i] = '.';
            }
        }
    }

    public static void main(String[] args) {
        int n = 4;
        List<List<String>> ret = new Collect_Q51().solveNQueens(n);
        System.out.println(ret);
    }
}