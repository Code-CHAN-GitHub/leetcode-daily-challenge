package com.leetcode.collect.盛最多水的容器;

import com.leetcode.utils.myassert.AssertUtils;

public class Collect_Q11 {
    
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1, ans = 0;
        while (left < right) {
            int area;
            if (height[left] < height[right])
                area = (right - left) * height[left++];
            else 
                area = (right - left) * height[right--];
            if (area > ans) ans = area;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int ret = new Collect_Q11().maxArea(height);
        AssertUtils.assertTrue(ret == 49);
    }
    
}