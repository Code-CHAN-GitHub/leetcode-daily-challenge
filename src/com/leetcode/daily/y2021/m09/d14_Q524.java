package com.leetcode.daily.y2021.m09;

import java.util.Arrays;
import java.util.List;

public class d14_Q524 {

    /* 动态规划 */
    public String findLongestWord(String s, List<String> dictionary) {
        String res = "";
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[][] dp = new int[n][128];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 'a'; j <= 'z'; j++) {
                if (chars[i] == j)
                    dp[i][j] = i;
                else 
                    dp[i][j] = i == n - 1 ? n : dp[i + 1][j];
            }
        }
        for (String str : dictionary) {
            char[] word = str.toCharArray();
            int i = 0, j = 0;
            while (i < chars.length && j < word.length) {
                i = dp[i][word[j]];
                if (i >= chars.length)
                    break;
                j++;
                i++;
            }
            if (j == word.length && 
                    (
                        str.length() > res.length() ||
                        (
                            str.length() == res.length() &&
                            str.compareTo(res) < 0
                        )
                    )
               ) {
                res = str;
            }
        }
        
        return res;
    }

    /* 双指针 */
    // public String findLongestWord(String s, List<String> dictionary) {
    //     String res = "";
    //     char[] chars = s.toCharArray();
    //     for (String str : dictionary) {
    //         char[] word = str.toCharArray();
    //         int i = 0, j = 0;
    //         while (i < chars.length && j < word.length) {
    //             if (chars[i] == word[j])
    //                 j++;
    //             i++;
    //         }
    //         if (j == word.length) {
    //             if (str.length() > res.length() ||
    //                 (
    //                     str.length() == res.length() &&
    //                     str.compareTo(res) < 0
    //                 )) {
    //                 res = str;   
    //             }
    //         }
    //     }
    //     return res;
    // }

    public static void main(String[] args) {
        String s = "abpcplea";
        List<String> dictionary = Arrays.asList("ale","apple","monkey","plea");
        String res = new d14_Q524().findLongestWord(s, dictionary);
        System.out.println(res);
    }
    
}