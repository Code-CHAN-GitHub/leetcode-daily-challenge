package com.leetcode.daily.y2021.m08;/**
 * @author chen
 * @create 2021-08-28-11:25
 */

import java.util.Arrays;

/**
 *@ClassName d28_Q1480
 *@Description running-sum-of-1d-array
 *Author chen
 *Date 2021/8/28 11:25
 *Version 1.0
 *@See <a href="https://leetcode-cn.com/problems/running-sum-of-1d-array/">running-sum-of-1d-array</a>
 **/
public class d28_Q1480 {

    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] res = new d28_Q1480().runningSum(nums);
        System.out.println(Arrays.toString(res));
    }
}
