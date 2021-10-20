package com.leetcode.daily.y2021.m10;

class d20_Q453 {
    public int minMoves(int[] nums) {
        long s = 0;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            s += num;
            min = Math.min(min, num);
        }
        return (int) (s - (long) min * nums.length);
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int res = new d20_Q453().minMoves(nums);
        System.out.println(res);
    }
}