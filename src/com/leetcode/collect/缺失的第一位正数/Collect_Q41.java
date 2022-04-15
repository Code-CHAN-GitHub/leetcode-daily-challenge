package com.leetcode.collect.缺失的第一位正数;

import com.leetcode.utils.myassert.AssertUtils;

public class Collect_Q41 {
    
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int i, sz = n;
        for (i = 0; i < n; i++) {
            if (nums[i] < 1 || nums[i] > n) 
                nums[i] = -1;
            else
                nums[i]--;
        }
        i = 0;
        while (i < n) {
            if (nums[i] >= 0 && nums[nums[i]] != nums[i]) {
                int t = nums[nums[i]]; nums[nums[i]] = nums[i]; nums[i] = t;
            } else {
                i++;
            }
        }
        for (i = 0; i < n; i++)
            if (nums[i] != i)
                return i + 1;
        return n + 1;
    }

    public static void main(String[] args) {
        int[] nums = {3,4,-1,1};
        int ret = new Collect_Q41().firstMissingPositive(nums);
        AssertUtils.assertTrue(ret == 2);
    }

}