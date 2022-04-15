package com.leetcode.daily.y2022.m01;

import com.leetcode.utils.myassert.AssertUtils;

public class d12_Q334 {

    public boolean increasingTriplet(int[] nums) {
        long[] f = new long[3];
        f[1] = f[2] = (long) 1e19; // f[1]: 长度为 1 序列结尾的值，f[2]: 长度为 2 序列结尾的值
        for (int num : nums) {
            if (num > f[2]) return true;
            else if (num > f[1] && num < f[2]) f[2] = num;
            else if (num < f[1]) f[1] = num;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 0, 4, 6};
        boolean ret = new d12_Q334().increasingTriplet(nums);
        AssertUtils.assertTrue(ret);
    }
    
}