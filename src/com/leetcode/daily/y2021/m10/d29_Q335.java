package com.leetcode.daily.y2021.m10;


class d29_Q335 {

    public boolean isSelfCrossing(int[] d) {
        if (d.length < 4) return false;
        for (int i = 3 ; i < d.length; i++) {
            if (d[i] >= d[i - 2] && d[i - 1] <= d[i - 3]) return true;
            if (i >= 4 && d[i - 1] == d[i - 3] && d[i] + d[i - 4] >= d[i - 2]) return true;
            if (i >= 5 && d[i - 1] <= d[i - 3] && d[i - 2] > d[i - 4] && d[i] + d[i - 4] >= d[i - 2] && d[i - 1] + d[i - 5] >= d[i - 3]) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] distance = {1, 1, 2, 1, 1};
        boolean res = new d29_Q335().isSelfCrossing(distance);
        System.out.println(res);
    }
}