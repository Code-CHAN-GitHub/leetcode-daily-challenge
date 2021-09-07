package com.leetcode.daily.y2021.m09;

/**
 * @see <a href="https://leetcode-cn.com/problems/split-a-string-in-balanced-strings/">split-a-string-in-balanced-strings</a>
 */
class d07_Q1221 {

    public int balancedStringSplit(String s) {
        char[] chars = s.toCharArray();
        int cnt = 0, res = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'L')
                cnt++;
            else 
                cnt--;
            if (cnt == 0)
                res++;
        }
        return res;
    }


    /* 分治实现 */

    // public int balancedStringSplit(String s) {
    //     char[] chars = s.toCharArray();
    //     return merge(chars, 0, chars.length - 1);
    // }

    // private int merge(char[] chars, int left, int right) {
    //     if (left >= right)
    //         return 0;
    //     int cntR = 0, cntL = 0;
    //     int maxLen = 0, maxInx = -1;
    //     for (int i = left; i <= right; i++) {
    //         if (chars[i] == 'L')
    //             cntL++;
    //         else 
    //             cntR++;
    //         if (cntL == cntR && Math.min(i - left + 1, right - i) > maxLen) {
    //             maxInx = i;
    //             maxLen = Math.min(i - left + 1, right - i);
    //         }
    //     }
    //     if (maxLen == 0)
    //         return 1;
    //     return merge(chars, left, maxInx) + merge(chars, maxInx + 1, right);
    // }

    public static void main(String[] args) {
        String s = "RLRRLLRLRL";
        int res = new d07_Q1221().balancedStringSplit(s);
        System.out.println(res);
    }
    
}