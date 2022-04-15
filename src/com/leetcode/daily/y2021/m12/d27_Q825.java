package com.leetcode.daily.y2021.m12;

import java.util.Arrays;

public class d27_Q825 {
 
    /**
     *  排序 + 双指针
        Arrays.sort(ages);
        int n = ages.length;
        int left = 0, right = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            while (right < n - 1 && ages[right + 1] <= ages[i])
                right++;
            while (left <= right && ages[left] <= 0.5 * ages[i] + 7)
                left++;
            ans += Math.max(0, right - left);
        }
        return ans;
     */

    public int numFriendRequests(int[] ages) {
        int N = 130;
        int[] nums = new int[N];
        for (int i : ages) nums[i]++;
        for (int i = 1; i < N; i++) nums[i] += nums[i - 1];
        int ans = 0;
        for (int x = 1, y = 1; y < N; y++) {
            int a = nums[y] - nums[y - 1];
            if (a == 0) continue;
            if (x < y) x = y;
            while (x < N && check(x, y)) x++;
            int b = nums[x - 1] - nums[y - 1] - 1;
            if (b > 0) ans += b * a;
        }
        return ans;
    }

    boolean check(int x, int y) {
        if (y <= 0.5 * x + 7) return false;
        if (y > x) return false;
        if (y > 100 && x < 100) return false;
        return true;
    }

    public static void main(String[] args) {
        // int[] ages = {20, 30, 100, 110, 120};
        int[] ages = {16, 16};
        int res = new d27_Q825().numFriendRequests(ages);
        System.out.println(res);
    }

}