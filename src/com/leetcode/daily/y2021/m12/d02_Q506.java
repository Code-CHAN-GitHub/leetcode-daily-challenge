package com.leetcode.daily.y2021.m12;

import java.util.Arrays;

public class d02_Q506 {
    
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = score[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, (a, b) -> b[0] - a[0]);
        String[] s = new String[]{"Gold Medal", "Silver Medal", "Bronze Medal"};
        String[] ans = new String[n];
        for (int i = 0; i < n; i++) {
            if (i < 3) {
                ans[arr[i][1]] = s[i];
            } else {
                ans[arr[i][1]] = String.valueOf(i + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] score = {10, 3, 8, 9, 4};
        String[] res = new d02_Q506().findRelativeRanks(score);
        System.out.println(Arrays.toString(res));
    }

}