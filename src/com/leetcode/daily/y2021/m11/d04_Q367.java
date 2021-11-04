package com.leetcode.daily.y2021.m11;

class d04_Q367 {

    public boolean isPerfectSquare(int _n) {
        long n = _n;
        long lo = 1, hi = n / 2 + 2;
        while (lo != hi) {
            long mid = lo + (hi - lo) / 2;
            if (mid * mid == n)
                return true;
            else if (mid * mid < n)
                lo = mid + 1; 
            else 
                hi = mid;
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 16;
        boolean res = new d04_Q367().isPerfectSquare(n);
        System.out.println(res);
    }

}