package com.leetcode.daily.y2021.m10;

class d06_Q414 {

    long INF = (long)-1e18;
    public int thirdMax(int[] nums) {
        long a = INF, b = INF, c = INF;
        for (int x : nums) {
            if (x > a) {
                c = b; b = a; a = x;
            } else if (x < a && x > b) {
                c = b; b = x;
            } else if (x < b && x > c) {
                c = x;
            }
        }
        return c != INF ? (int)c : (int)a;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1};
        int res = new d06_Q414().thirdMax(nums);
        System.out.println(res);
    }

}