package com.leetcode.daily.y2021.m12;

import java.util.Arrays;

public class d08_Q689 {
    
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) sum[i] = nums[i - 1] + sum[i - 1];
        int[][] dp = new int[n + 10][4];
        for (int i = n - k + 1; i > 0; i--) {
            for (int j = 1; j <= 3; j++) {
                dp[i][j] = Math.max(dp[i + 1][j], sum[i + k - 1] - sum[i - 1] + dp[i + k][j - 1]);
            }
        }
        int[] ans = new int[3];
        int idx = 0, i = 1, j = 3;
        while (j > 0) {
            if (sum[i + k - 1] - sum[i - 1] + dp[i + k][j - 1] >= dp[i + 1][j]) {
                ans[idx++] = i - 1;
                i += k; j--;
            } else {
                i++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,2,6,7,5,1};
        int k = 2;
        int[] res = new d08_Q689().maxSumOfThreeSubarrays(nums, k);
        System.out.println(Arrays.toString(res));
    }

}