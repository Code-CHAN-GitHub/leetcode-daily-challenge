package com.leetcode.daily.y2021.m10;

import java.util.ArrayList;
import java.util.List;

class d16_Q282 {

    char[] s;
    int target;
    List<String> ans = new ArrayList<>();
    
    public List<String> addOperators(String num, int _target) {
        s = num.toCharArray();
        target = _target;
        StringBuilder sb = new StringBuilder();
        long t = 0;
        for (int i = 0; i < s.length; i++) {
            t = t * 10 + (s[i] - '0');
            sb.append(s[i]);
            dfs(i + 1, t, t, 0, false, sb);
            if (s[0] == '0')
                break;
        }
        return ans;
    }
    
    private void dfs(int i, long sum, long pre, long x, boolean flag, StringBuilder sb) {
        if (i == s.length) {
            if (sum == target)
                ans.add(sb.toString());
            return;
        }
        long num = 0;
        int len = sb.length();
        for (int j = i; j < s.length; j++) {
            num = num * 10 + (s[j] - '0');
            // +
            sb.append("+").append(num);
            dfs(j + 1, sum + num, num, 0, false,sb);
            sb.delete(len, sb.length());
            // -
            sb.append("-").append(num);
            dfs(j + 1, sum - num, -num, 0, false, sb);
            sb.delete(len, sb.length());
            // *
            sb.append("*").append(num);
            if (!flag) {
                dfs(j + 1, sum - pre + pre * num, num, pre * num, true, sb);
            } else {
                dfs(j + 1, sum - x + x * num, num, x * num, true, sb);
            }
            sb.delete(len, sb.length());
            if (s[i] == '0')
                break;
        }
    }

    public static void main(String[] args) {
        String num = "010";
        int target = 0;
        List<String> res = new d16_Q282().addOperators(num, target);
        System.out.println(res);
    }

}