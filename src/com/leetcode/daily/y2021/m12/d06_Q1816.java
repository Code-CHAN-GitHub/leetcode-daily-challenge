package com.leetcode.daily.y2021.m12;

public class d06_Q1816 {

    public String truncateSentence(String s, int k) {
        int i = 0;
        while (k > 0 && i < s.length()) {
            i++;
            if (i < s.length() && s.charAt(i) == ' ') {
                k--;
            }
        }
        return s.substring(0, i);
    }

    public static void main(String[] args) {
        String s = "Hello how are you Contestant";
        int k = 4;
        String res = new d06_Q1816().truncateSentence(s, k);
        System.out.println(res);
    }
    
}