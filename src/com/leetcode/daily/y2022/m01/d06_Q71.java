package com.leetcode.daily.y2022.m01;

import com.leetcode.utils.myassert.AssertUtils;

public class d06_Q71 {

    public String simplifyPath(String path) {
        char[] s1 = path.toCharArray();
        char[] s2 = new char[s1.length];
        int n = s1.length;
        int i = 0, j = 0;
        while (i < n) {
            while (i < n && s1[i] == '/')
                i++;
            if (i == n) break;
            boolean read = true;
            if (s1[i] == '.') {
                if (i + 1 < n && s1[i + 1] == '.' && (i + 2 == n || s1[i + 2] == '/')) {
                    s2[j] = ' ';
                    while (j > 0 && s2[j] != '/')
                        j--;
                    read = false;
                } else if (i + 1 == n || s1[i + 1] == '/') {
                    read = false;
                }
            }
            if (read) s2[j++] = '/';
            while (i < n && s1[i] != '/') {
                if (read) s2[j++] = s1[i];
                i++;
            }
        }
        return j == 0 ? "/" : new String(s2, 0, j);
    }

    public static void main(String[] args) {
        String path = "/a/./b/../../c/";
        String ret = new d06_Q71().simplifyPath(path);
        AssertUtils.assertTrue(ret.equals("/c"));
    }
    
}