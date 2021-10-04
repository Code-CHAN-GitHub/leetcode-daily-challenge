package com.leetcode.daily.y2021.m10;


class d04_Q482 {

    public String licenseKeyFormatting(String s, int k) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c != '-') {
                c = (c >= 'a' && c <= 'z') ? (char) (c + ('A' - 'a')) : c;
                sb.append(c);
                if (++cnt == k) {
                    sb.append("-");
                    cnt = 0;
                }
            }
        }
        while (sb.length() > 0 && sb.charAt(sb.length() - 1) == '-')
            sb.delete(sb.length() - 1, sb.length());
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "5F3Z-2e-9-w";
        int k = 4;
        String res = new d04_Q482().licenseKeyFormatting(s, k);
        System.out.println(res);
    }

}