package com.leetcode.daily.y2022.m01;

import java.util.HashSet;
import java.util.Set;

import com.leetcode.utils.myassert.AssertUtils;

public class d19_Q219 {
    
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int left = 0, right = 0;
        while (right < nums.length) {
            if (!set.add(nums[right++]))
                return true;
            if (right - left > k)
                set.remove(nums[left++]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        boolean ret = new d19_Q219().containsNearbyDuplicate(nums, k);
        AssertUtils.assertTrue(ret);
    }
    
}