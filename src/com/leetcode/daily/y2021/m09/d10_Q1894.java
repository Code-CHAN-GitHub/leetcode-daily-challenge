package com.leetcode.daily.y2021.m09;

public class d10_Q1894 {
    
    public int chalkReplacer(int[] chalk, int k) {
        //  5   1   5
        //  5   6   11
        int n = chalk.length;
        for (int i = 0; i < n; i++) {
            if (i > 0)
                chalk[i] += chalk[i - 1];
            if (chalk[i] > k)
                return i;
        }
        k %= chalk[n - 1];
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (chalk[mid] == k)
                return mid + 1;
            else if (chalk[mid] > k)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return right + 1;
    }

    public static void main(String[] args) {
        int[] chalk = {5, 1, 5};
        int k = 22;
        int res = new d10_Q1894().chalkReplacer(chalk, k);
        System.out.println(res);
    }
}