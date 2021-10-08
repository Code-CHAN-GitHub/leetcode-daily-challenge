package com.leetcode.daily.y2021.m10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class d08_Q187 {

    // 'A' -> 00  'C' -> '01'  'G' -> '10'  'T' -> '11'
    // ACCT..A ->  00..0011010100     

    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        List<String> ans = new ArrayList<>();
        if (n < 10) return ans;

        int win = 0;
        for (int i = 0; i < 10; i++) {
            int x = toInt(s.charAt(i));
            win |= x << (i * 2);
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(win, 1);
        for (int i = 10; i < n; i++) {
            win = (win >> 2) | toInt(s.charAt(i)) << 18;
            map.put(win, map.getOrDefault(win, 0) + 1);
            if (map.get(win) == 2) {
                ans.add(s.substring(i - 9, i + 1));
            }
        }

        return ans;
    }   

    private int toInt(char c) {
        switch(c) {
            case 'A': return 0;
            case 'C': return 1;
            case 'G': return 2;
            case 'T': return 3;
        }
        return -1;
    }


    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> res = new d08_Q187().findRepeatedDnaSequences(s);
        res.forEach(System.out::println);
    }
}