package com.leetcode.daily.y2021.m10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class d03_Q166 {

    public String fractionToDecimal(int _n, int _d) {
        if (_n == 0) return "0";
        
        StringBuilder sb = new StringBuilder();
        if ((_n ^ _d) >>> 31 != 0)
            sb.append("-");
        long n = Math.abs((long) _n);
        long d = Math.abs((long) _d);
        sb.append(n / d);
        n %= d;
        if (n != 0)
            sb.append(".");

        int i;
        long k;
        Map<Long,Integer> map = new HashMap<>();
        while (n > 0) {
            n *= 10;
            k = n / d;
            if (!map.isEmpty() && map.containsKey(n)) {
                i = map.get(n);
                sb.insert(i, "(");
                sb.append(")");
                break;
            }
            sb.append(k);
            map.put(n, sb.length() - 1);
            n %= d;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int n = 1, d = 6;
        String res = new d03_Q166().fractionToDecimal(n, d);
        System.out.println(res);
    }
    
}