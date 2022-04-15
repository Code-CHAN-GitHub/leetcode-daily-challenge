package com.leetcode.daily.y2022.m01;

import com.leetcode.utils.myassert.AssertUtils;

public class d27_Q2047 {
 
    public int countValidWords(String sentence) {
        char[] s = sentence.toCharArray();
        int i = 0, ans = 0, n = s.length;
        while (i < n) {
            while (i < n && s[i] == ' ')
                i++;
            if (i == n) break;
            boolean ok = true, use = false;
            while (i < n && s[i] != ' ') {
                if (Character.isDigit(s[i])) {
                    ok = false;
                } else if (s[i] == '-') {
                    if (use || i - 1 < 0 || !Character.isAlphabetic(s[i - 1]) || 
                            i + 1 >= n || !Character.isAlphabetic(s[i + 1])) {
                        ok = false;
                    }
                    use = true;
                } else if ((s[i] == '!' || s[i] == '.' || s[i] == ',') && 
                           i + 1 < n && s[i + 1] != ' ') {
                    ok = false;
                }        
                i++;
            }
            if (ok) ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        String sentence = "alice and  bob are playing stone-game10";
        int ret = new d27_Q2047().countValidWords(sentence);
        AssertUtils.assertTrue(ret == 5);
    }

}