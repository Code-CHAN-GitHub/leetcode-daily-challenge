package com.leetcode.daily.y2021.m10;

class d18_Q476 {

    public int findComplement(int num) {
        return (~num) & (Integer.highestOneBit(num) << 1) - 1;
    }

    public static void main(String[] args) {
        int num = 1000;
        int res = new d18_Q476().findComplement(num);
        System.out.println(res);
    }
    
}