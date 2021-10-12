package com.leetcode.daily.y2021.m10;

class d12_Q29 {

    public int divide(int _a, int _b) {
        boolean flag = ((_a ^ _b) & (1 << 31)) != 0;
        long a = Math.abs((long) _a), b = Math.abs((long) _b);
        long ans = 0;
        long x = b, t = 1;
        while (a >= b) {
            if (x + x > a) {
                a -= x;
                ans += t;
                t = 1;
                x = b;
            } else {
                x += x;
                t <<= 1;                
            }
        }
        if (flag) ans = -ans;
        if (ans < 0x80000000 || ans > 0x7FFFFFFF) ans = 0x7FFFFFFF;
        return (int) ans;
    }

    public static void main(String[] args) {
        int _a = -2147483648, _b = -1; 
        int res = new d12_Q29().divide(_a, _b);
        System.out.println(res);
    }

}