package com.leetcode.daily.y2021.m12;

public class d12_Q709 {
    
    public String toLowerCase(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if ('A' <= chars[i] && chars[i] <= 'Z') {
                chars[i] = (char)('a' + (chars[i] - 'A'));
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String s = "LOVELY";
        String res = new d12_Q709().toLowerCase(s);
        System.out.println(res);
    }

}