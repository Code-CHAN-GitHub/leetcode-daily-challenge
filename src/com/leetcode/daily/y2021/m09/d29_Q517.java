package com.leetcode.daily.y2021.m09;

import java.util.PriorityQueue;

class d29_Q517 {
    
    public int findMinMoves(int[] ms) {
        int sum = 0, n = ms.length;
        for (int i : ms) sum += i;
        if (sum % n != 0) return -1;
        int t = sum / n;
        int ls = 0, rs = sum;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            rs -= ms[i];
            int a = Math.max(t * i - ls, 0);
            int b = Math.max(t * (n - i - 1) - rs, 0);
            ans = Math.max(ans, a + b);
            ls += ms[i];
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] machines = {1, 0, 5};
        int res = new d29_Q517().findMinMoves(machines);
        System.out.println(res);
    }
}