package com.leetcode.daily.y2022.m01;

import com.leetcode.utils.myassert.AssertUtils;

public class d07_Q1614 {

    public int maxDepth(String s) {
        int ans = 0, l = 0, r = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                if (++l > ans) ans = l;
            }
            else if (c == ')') {
                r++; l--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "(1+(2*3)+((8)/4))+1";
        int ret = new d07_Q1614().maxDepth(s);
        AssertUtils.assertTrue(ret == 3);
    }
    
}