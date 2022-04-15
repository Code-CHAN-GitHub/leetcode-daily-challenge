package com.leetcode.exercise;

public class Q_strStr {

    public int strStr(String haystack, String needle) { 
        if ("".equals(needle)) return 0;
        char[] s1 = haystack.toCharArray();
        char[] s2 = needle.toCharArray();

        int n = s2.length;
        int[] next = new int[n];
        next[0] = -1;
        int i = 0, j = -1;
        while (i < n - 1) {
            if (j < 0 || s2[i] == s2[j]) {
                i++; j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }

        i = 0; j = 0;
        while (i < s1.length) {
            if (j < 0 || s1[i] == s2[j]) {
                i++; j++;
                if (j == s2.length)
                    return i - n;
            } else 
                j = next[j];
        }
        
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "a";
        String needle = "a";
        int res = new Q_strStr().strStr(haystack, needle);
        System.out.println(res);
    }
}