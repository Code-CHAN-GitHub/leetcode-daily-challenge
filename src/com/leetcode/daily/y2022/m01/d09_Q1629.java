package com.leetcode.daily.y2022.m01;

import com.leetcode.utils.myassert.AssertUtils;

public class d09_Q1629 {
    
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char ans = 'a';
        char[] chars = keysPressed.toCharArray();
        int max = 0, i = 0, s = 0;
        while (i < chars.length) {
            int t = releaseTimes[i] - s;
            if (t > max) {
                max = t; ans = chars[i];
            } else if (t == max && chars[i] > ans) {
                ans = chars[i];
            }
            s = releaseTimes[i++];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] releaseTimes = {9, 29, 49, 50};
        String keysPressed = "cbcd";
        char ret = new d09_Q1629().slowestKey(releaseTimes, keysPressed);
        AssertUtils.assertTrue(ret == 'c');
    }
    
}