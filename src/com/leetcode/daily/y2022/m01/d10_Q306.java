package com.leetcode.daily.y2022.m01;

import com.leetcode.utils.myassert.AssertUtils;

public class d10_Q306 {

    public boolean isAdditiveNumber(String num) {
        char[] s = num.toCharArray();
        long a = 0, b;
        for (int i = 0; i < s.length; i++) {
            a = a * 10 + (s[i] - '0');
            b = 0;
            for (int j = i + 1; j < s.length; j++) {
                b = b * 10 + (s[j] - '0');
                if (dfs(s, j + 1, a, b)) {
                    return true;
                }
                if (b == 0) break;
            }
            if (a == 0) break;
        }
        return false;
    }
    
    private boolean dfs(char[] s, int i, long a, long b) {
        long c = a + b;
        String strC = String.valueOf(c);
        int j;
        for (j = 0; j < strC.length() && i + j < s.length; j++) {
            if (s[i + j] != strC.charAt(j))
                return false;
        }
        if (j < strC.length()) 
            return false;
        if (i + j == s.length)
            return true;
        return dfs(s, i + j, b, c);
    }

    public static void main(String[] args) {
        String num = "199100199";
        boolean ret = new d10_Q306().isAdditiveNumber(num);
        AssertUtils.assertTrue(ret);
    }
    
}