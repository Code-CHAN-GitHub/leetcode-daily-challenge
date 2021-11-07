package com.leetcode.daily.y2021.m11;

class d07_Q598 {

    public int maxCount(int m, int n, int[][] ops) {
        int i = m, j = n;
        for (int[] op : ops) {
            i = Math.min(i, op[0]);
            j = Math.min(j, op[1]);
        }
        return i * j;
    }

    public static void main(String[] args) {
        int m = 3, n = 3;
        int[][] ops = {{2, 2}, {3, 3}};
        int res = new d07_Q598().maxCount(m, n, ops);
        System.out.println(res);
    }

}