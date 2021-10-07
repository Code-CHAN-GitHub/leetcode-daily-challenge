package com.leetcode.daily.y2021.m10;

class d07_Q434 {

    public int countSegments(String s) {
        int i = -1, n = s.length(), ans = 0;
        while (i < n - 1) {
            while (i < n - 1 && s.charAt(++i) == ' ');
            if (i <= n - 1 && s.charAt(i) != ' ')
                ans++;
            while (i < n - 1 && s.charAt(++i) != ' ');
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "Hello, my name is John";
        int res = new d07_Q434().countSegments(s);
        System.out.println(res);
    }

}