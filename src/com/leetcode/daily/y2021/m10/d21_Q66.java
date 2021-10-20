package com.leetcode.daily.y2021.m10;

import java.util.Arrays;

class d21_Q66 {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int i = n - 1;
        while (i >= 0 && ++digits[i] == 10) {
            digits[i--] = 0;
        }
        int[] res = digits;
        if (i == -1) {
            res = new int[n + 1];
            res[0] = 1;
            for (int j = 2; j < n; j++)
                res[j] = digits[j - 1];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] digits = {9, 9, 9};
        int[] res = new d21_Q66().plusOne(digits);
        System.out.println(Arrays.toString(res));
    }
}