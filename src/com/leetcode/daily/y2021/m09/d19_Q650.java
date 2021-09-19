package com.leetcode.daily.y2021.m09;

public class d19_Q650 {

    public int minSteps(int n) {
        int ans = 0;
        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                n /= i;
                ans += i;
            }
        }
        if (n != 1) ans += n;
        return ans;
    }

    public static void main(String[] args) {
        int n = 1000;
        int res = new d19_Q650().minSteps(n);
        System.out.println(res);
    }
    
}