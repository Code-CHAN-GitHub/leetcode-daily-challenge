package com.leetcode.daily.y2021.m10;

class d15_Q38 {

    static String[] f = new String[31];
    static {
        f[1] = "1";
        for (int k = 2; k <= 30; k++) {
            int i = 0;
            StringBuilder sb = new StringBuilder();
            char[] s = f[k - 1].toCharArray();
            while (i < s.length) {
                int j = i + 1;
                while (j < s.length && s[j] == s[j - 1])
                    j++;
                sb.append(j - i).append(s[i]);
                i = j;
            }
            f[k] = sb.toString();
        }
    }
    
    public String countAndSay(int n) {
        return f[n];
    }

    public static void main(String[] args) {
        int n = 10;
        String res = new d15_Q38().countAndSay(n);
        System.out.println(res);
    }

}