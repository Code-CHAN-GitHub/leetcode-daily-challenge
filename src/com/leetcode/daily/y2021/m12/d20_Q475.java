package com.leetcode.daily.y2021.m12;

import java.util.Arrays;

public class d20_Q475 {

    public int findRadius(int[] houses, int[] heaters) {
        int n = houses.length, m = heaters.length;
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int[] h = new int[m + 2];
        h[0] = (int) -(1e9 + 10);
        h[m + 1] = (int) (2e9 + 10);
        int i = 0, j = 1, max = 0;
        System.arraycopy(heaters, 0, h, 1, m);
        int lo = h[0], hi = h[1];
        while (i < n && j < m + 2) {
            while (houses[i] > hi) {
                lo = hi;
                hi = h[++j];
            }
            max = Math.max(max, Math.min(houses[i] - lo, hi - houses[i]));
            i++;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] houses = {1, 2, 3, 4};
        int[] heaters = {1, 4};
        int res = new d20_Q475().findRadius(houses, heaters);
        System.out.println(res);
    }
}