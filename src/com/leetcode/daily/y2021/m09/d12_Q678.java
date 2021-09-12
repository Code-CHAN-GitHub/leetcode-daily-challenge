package com.leetcode.daily.y2021.m09;

import java.util.Stack;

public class d12_Q678 {


    public boolean checkValidString(String s) {
        char[] chars = s.toCharArray();
        int min = 0, max = 0; // '(' 数量范围 [min, max]
        for (char c : chars) {
            if (c == '(') {
                min++; max++;
            } else if (c == ')') {
                if (min > 0) min--; // min 小于 0, 说明左侧 ) 多于 ( , 再增加 ( 也不合法
                if (max-- == 0) return false; // 不够用了
            } else {
                if (min > 0) min--; // '*' 当作 ')'
                max++; // '*' 当作 '('
            }
        }
        return min == 0;
    }

    // public boolean checkValidString(String s) {
    //     char[] chars = s.toCharArray();
    //     int n = chars.length, left = 0, right = 0;
    //     for (int i = 0; i < n; i++) {
    //         left += (chars[i] == ')') ? -1 : 1;
    //         right += (chars[n - i - 1] == '(') ? -1 : 1;
    //         if (left < 0 || right < 0)
    //             return false;
    //     }
    //     return true;
    // }
    
    public static void main(String[] args) {
        String s = "(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())";
        boolean res = new d12_Q678().checkValidString(s);
        System.out.println(res);
    }
    
}