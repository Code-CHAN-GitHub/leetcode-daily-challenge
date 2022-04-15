package com.leetcode.daily.y2021.m12;

public class d17_Q1518 {

    public int numWaterBottles(int n, int m) {
        int ans = n;
        while (n >= m) {
            int a = n / m, b = n % m;
            ans += a;
            n = a + b;
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int n = 9;
        int m = 3;
        int res = new d17_Q1518().numWaterBottles(n, m);
        System.out.println(res);
    }

}