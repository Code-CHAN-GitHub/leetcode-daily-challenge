package com.leetcode.daily.y2021.m11;

class d01_Q575 {

    public int distributeCandies(int[] candyType) {
        boolean[] set = new boolean[200010];
        int ans = 0, n = candyType.length;
        for (int i = 0; i < n && ans < n / 2; i++) {
            int type = candyType[i] + 100000;
            if (!set[type]) {
                set[type] = true;
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] candyType = {1,1,2,2,3,3};
        int res = new d01_Q575().distributeCandies(candyType);
        System.out.println(res);
    }

}