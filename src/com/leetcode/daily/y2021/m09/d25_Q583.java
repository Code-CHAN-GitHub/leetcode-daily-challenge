package com.leetcode.daily.y2021.m09;

class d25_Q583 {

    public int minDistance(String word1, String word2) {
        char[] s1 = word1.toCharArray();
        char[] s2 = word2.toCharArray();
        int n = s1.length, m = s2.length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1[i - 1] == s2[j - 1])
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else 
                    dp[i][j] = Math.max(dp[i - 1][j],  dp[i][j - 1]);
            }
        }
        return m + n - 2 * dp[n][m];
    }

    public static void main(String[] args) {
        String word1 = "sea";
        String word2 = "eat";
        int res = new d25_Q583().minDistance(word1, word2);
        System.out.println(res);
    }

}