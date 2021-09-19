package com.leetcode.daily.y2021.m09;

public class d18_Q292 {
    
    // 1, 2, 3 true
    // 4 -> [1|2|3] false (谁拿到 4 谁必输)
    // 5 -> [2|3|4]
    // 6 -> [3|4|5]
    // 7 -> [4|5|6] (5,6,7 都可以让对方拿到 4，则自己获胜)
    // 8 -> [5,6,7] (8 能让对方拿到 5，6，7 则自己输)
    // 以此类推 n % 4 == 0 则必输
    
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
    

    public static void main(String[] args) {
        int n = 4;
        boolean res = new d18_Q292().canWinNim(n);
        System.out.println(res);
    }
}
