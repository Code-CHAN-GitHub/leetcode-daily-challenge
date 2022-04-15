package com.leetcode.daily.y2022.m01;

import com.leetcode.utils.myassert.AssertUtils;

public class d02_Q390 {

    public int lastRemaining(int n) {
        int left = 1, right = n;
        int i = 1;
        while (left != right) {
            int d = 1 << (i - 1);
            if (i % 2 != 0) {
                if (((right - left) / d) % 2 == 0) right -= d;
                left += d;
            } else {
                if (((right -left) / d) % 2 == 0) left += d;
                right -= d;
            }
            i++;
        }
        return left;
    }

    public static void main(String[] args) {
        int n = 9;
        int ret = new d02_Q390().lastRemaining(n);
        AssertUtils.assertTrue(ret == 6);
    }
    
}