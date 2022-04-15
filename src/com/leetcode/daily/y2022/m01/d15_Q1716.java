package com.leetcode.daily.y2022.m01;

import com.leetcode.utils.myassert.AssertUtils;

public class d15_Q1716 {

    public int totalMoney(int n) {
        int a = n / 7;
        int b = n % 7;
        int s = a * 28 + Math.max(0, (a * (a - 1)) / 2) * 7;
        s += (b * (b + 1) / 2) + b * a;
        return s;
    }

    public static void main(String[] args) {
        int n = 20;
        int ret = new d15_Q1716().totalMoney(n);
        AssertUtils.assertTrue(ret == 96);
    }
    
}