package com.leetcode.daily.y2022.m01;

import java.util.Arrays;

import com.leetcode.utils.myassert.AssertUtils;

public class d01_Q2022 {

    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) return new int[][]{};
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = original[i * n + j];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] original = {1, 2, 3, 4};
        int m = 2, n = 2;
        int[][] ret = new d01_Q2022().construct2DArray(original, m, n);
        AssertUtils.assertTrue(Arrays.equals(ret[0], new int[]{1, 2}));
        AssertUtils.assertTrue(Arrays.equals(ret[1], new int[]{3, 4}));
    }
    
}