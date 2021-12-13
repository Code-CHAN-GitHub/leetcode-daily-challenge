package com.leetcode.daily.y2021.m12;

public class d01_Q1446 {
    
    public int maxPower(String s) {
        int max = 0, prev = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i == s.length() - 1 || s.charAt(i) != s.charAt(i + 1)) {
                max = Math.max(max, i - prev + 1);
                prev = i + 1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "hooraaaaaaaaaaa";
        int res = new d01_Q1446().maxPower(s);
        System.out.println(res);
    }

}