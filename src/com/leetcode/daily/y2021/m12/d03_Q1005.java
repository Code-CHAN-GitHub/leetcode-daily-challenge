package com.leetcode.daily.y2021.m12;

import java.util.Arrays;

public class d03_Q1005 {

    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0, n = nums.length;
        int sum = 0;
        while (i < n && k > 0 && nums[i] < 0) {
            nums[i] = -nums[i];
            sum += nums[i];
            i++; k--;
        }
        k %= 2;
        if (k == 1) {
            if (i < n) {
                if (i == 0 || nums[i] < nums[i - 1]) {
                    nums[i] = -nums[i];
                } else { 
                    sum -= nums[i - 1] << 1;
                }
            } else {
                sum -= nums[n - 1] << 1;
            }
        } 
        for (int j = i; j < n; j++) 
            sum += nums[j];
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {-4,-2,-3};
        int k = 4;
        int res = new d03_Q1005().largestSumAfterKNegations(nums, k);
        System.out.println(res);
    }
    
}