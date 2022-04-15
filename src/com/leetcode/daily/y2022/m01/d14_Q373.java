package com.leetcode.daily.y2022.m01;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class d14_Q373 {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        int l = nums1[0] + nums2[0], r = nums1[m - 1] + nums2[n - 1];
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (check(nums1, nums2, mid, k))
                r = mid - 1;
            else 
                l = mid + 1;
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i : nums1) {
            for (int j : nums2) {
                if (i + j > r)
                    break;
                ans.add(Arrays.asList(i, j));
                if (--k <= 0) return ans;
            }
        }
        for (int i : nums1) {
            
        }
        return ans;
    }
    
    private boolean check(int[] nums1, int[] nums2, int t, int k) {
        for (int i : nums1) {
            int l = 0, r = nums2.length - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (nums2[mid] <= t - i)
                    l = mid + 1;
                else 
                    r = mid - 1;
            }
            k -= l;
            if (k <= 0)
                return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        int[] nums1 = {0,0,0,0,0};
        int[] nums2 = {-3,22,35,56,76};
        int k = 22;
        List<List<Integer>> ret = new d14_Q373().kSmallestPairs(nums1, nums2, k);
        System.out.println(ret);
    }
}