package com.leetcode.daily.y2022.m01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.leetcode.utils.myassert.AssertUtils;

public class d08_Q89 {

    public List<Integer> grayCode(int n) {
        // 000 001 011 010 110 111 101 100
        int[] ans = new int[1 << n];
        ans[1] = 1;
        for (int i = 2; i * 2 <= ans.length; i <<= 1) {
            for (int j = 0; j < i; j++) {
                ans[i + j] = i | ans[i - j - 1];
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i : ans) list.add(i);
        return list;
    }

    public static void main(String[] args) {
        int n = 2;
        List<Integer> ret = new d08_Q89().grayCode(n);
        AssertUtils.assertTrue(
            !Collections.disjoint(ret, Arrays.asList(0, 1, 3, 2)));
    }
    
}