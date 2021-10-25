package com.leetcode.daily.y2021.m10;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class d24_Q638 {

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        long need = listToLong(needs, needs.size() - 1);
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 0);
        for (List<Integer> sp : special) {
            int p = sp.get(sp.size() - 1);
            long x = listToLong(sp, sp.size() - 2);
            Map<Long, Integer> tmp = new HashMap<>();
            for (Map.Entry<Long,Integer> entry : map.entrySet()) {
                for (int i = 1; ; i++) {
                    long t = x * i + entry.getKey();
                    if (check(need, t)) {
                        tmp.put(t, entry.getValue() + i * p);
                    } else {
                        break;
                    }
                }
            }
            for (Map.Entry<Long,Integer> entry : tmp.entrySet()) {
                map.put(entry.getKey(), Math.min(entry.getValue(), map.getOrDefault(entry.getKey(), Integer.MAX_VALUE)));
            }
        }
        int ans = Integer.MAX_VALUE;
        for (Map.Entry<Long,Integer> entry : map.entrySet()) {
            Long k = entry.getKey(), tN = need;
            int p = entry.getValue(), i = price.size() - 1;
            while (tN > 0) {
                p += ((tN % 100) - (k % 100)) * price.get(i--);
                tN /= 100;
                k /= 100;
            }
            ans = Math.min(ans, p);
        }
        return ans;
    }

    private long listToLong(List<Integer> list, int end) {
        long x = 0;
        for (int i = 0; i <= end; i++) {
            x = x * 100 + list.get(i);
        }
        return x;
    }

    private boolean check(long need, long t) {
        while (t > 0) {
            if ((t % 100) > (need % 100))
                return false;
            t /= 100;
            need /= 100;
        }
        return true;
    }


    public static void main(String[] args) {
        List<Integer> price = Arrays.asList(2, 5);
        List<List<Integer>> special = Arrays.asList(Arrays.asList(3, 0, 5), Arrays.asList(1, 2, 10));
        List<Integer> needs = Arrays.asList(3, 2);
        int res = new d24_Q638().shoppingOffers(price, special, needs);
        System.out.println(res);
    }

}