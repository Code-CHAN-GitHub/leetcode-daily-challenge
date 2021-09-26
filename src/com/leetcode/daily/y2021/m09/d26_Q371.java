package com.leetcode.daily.y2021.m09;

class d26_Q371 {

    public int getSum(int a, int b) {
        int xor = a ^ b;
        int and = a & b;
        while (and != 0) {
            and <<= 1;
            int t = xor;
            xor = t ^ and;
            and = t & and;
        }
        return xor;
    }

    public static void main(String[] args) {
        int a = 100;
        int b = 200;
        int res = new d26_Q371().getSum(a, b);
        System.out.println(res);
    }
}