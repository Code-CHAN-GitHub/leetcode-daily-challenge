package com.leetcode.daily.y2021.m09;

class d23_Q326 {

    public boolean isPowerOfThree(int n) {
        if (n == 0) return false;
        while (n % 3 == 0)
            n /= 3;
        return n == 1;
    }

    public static void main(String[] args) {
        int n = 27;
        boolean res = new d23_Q326().isPowerOfThree(n);
        System.out.println(res);
    }
    
}