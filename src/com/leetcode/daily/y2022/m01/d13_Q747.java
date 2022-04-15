package com.leetcode.daily.y2022.m01;

import com.leetcode.utils.myassert.AssertUtils;

public class d13_Q747 {

    public int dominantIndex(int[] nums) {
        int a = 0, b = nums[0], idx = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > b) {
                a = b; b = nums[i]; idx = i;
            } else if (nums[i] > a) {
                a = nums[i];
            }
        }
        return b >= a * 2 ? idx : -1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 6, 1, 0};
        int ret = new d13_Q747().dominantIndex(nums);
        AssertUtils.assertTrue(ret == 1);
    }
    
}