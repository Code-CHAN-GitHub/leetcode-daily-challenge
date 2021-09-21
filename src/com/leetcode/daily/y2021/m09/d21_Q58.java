package com.leetcode.daily.y2021.m09;

public class d21_Q58 {

    public int lengthOfLastWord(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int i = n - 1, j = 0;
        while (i >= 0 && chars[i] == ' ')
            i--;
        j = i;
        while (i >= 0 && chars[i] != ' ')
            i--;
        return j - i;
    }

    public static void main(String[] args) {
        String s = "   fly me   to   the moon  ";
        int res = new d21_Q58().lengthOfLastWord(s);
        System.out.println(res);
    }
    
}