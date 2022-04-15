package com.leetcode.daily.y2021.m12;

import java.util.PriorityQueue;

public class d25_Q1705 {

    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> heap = 
            new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int i = 0, n = apples.length, ans = 0;
        do {
            if (i < n && apples[i] > 0)
                heap.add(new int[]{apples[i], i + days[i]});
            int[] x = getFresh(i, heap);
            if (x != null) {
                ans++;
                if (--x[0] > 0) heap.add(x);
            }
            i++;
        } while (i < n);
        while (!heap.isEmpty()) {
            int[] x = getFresh(i, heap);
            if (x != null) {
                int t = Math.min(x[0], x[1] - i);
                ans += t;
                i += t;
            }
        }
        return ans;
    }

    private int[] getFresh(int i, PriorityQueue<int[]> heap) {
        while (!heap.isEmpty()) {
            int[] x = heap.poll();
            if (x[1] > i) return x;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] apples = {1,2,3,5,2};
        int[] days = {3,2,1,4,2};
        int res = new d25_Q1705().eatenApples(apples, days);
        System.out.println(res);
    }
    
}