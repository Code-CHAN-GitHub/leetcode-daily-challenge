package com.leetcode.daily.y2022.m01;

import com.leetcode.utils.myassert.AssertUtils;

public class d05_Q1576 {

    char[] chars;

    public String modifyString(String s) {
        if ("?".equals(s)) return "a";
        chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '?') {
                if (check(i, 'a')) chars[i] = 'a';
                else if (check(i, 'b')) chars[i] = 'b';
                else if (check(i, 'c')) chars[i] = 'c';
            }
        }
        return String.valueOf(chars);
    }

    public boolean check(int i, char c) {
        if (i == 0) return chars[i + 1] != c; 
        if (i == chars.length - 1) return chars[i - 1] != c;
        return chars[i + 1] != c && chars[i - 1] != c;
    }

    public static void main(String[] args) {
        String s = "j?qg??b";
        String ret = new d05_Q1576().modifyString(s);
        AssertUtils.assertTrue(ret.equals("jaqgacb"));
    }
    
}