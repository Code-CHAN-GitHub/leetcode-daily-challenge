package com.leetcode.daily.y2021.m11;

class d06_Q268 {


    public int missingNumber(int[] nums) {
        int n = nums.length;
        int ans = n, i = 0;
        while (i < n) {
            while (nums[i] != n && nums[i] != i) {
                swap(nums, nums[i], i);
            }
            if (nums[i] == n) 
                ans = i;
            i++;
        }
        return ans;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        int res = new d06_Q268().missingNumber(nums);
        System.out.println(res);
    }

}