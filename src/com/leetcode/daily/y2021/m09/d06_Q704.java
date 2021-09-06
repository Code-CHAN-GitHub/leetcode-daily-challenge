package com.leetcode.daily.y2021.m09;

/**
 * @see <a href="https://leetcode-cn.com/problems/binary-search/">binary-search</a>
 */
public class d06_Q704 {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length -1;
        while (left <= right) {
        	int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                right = mid - 1;
            else 
                left = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        int res = new d06_Q704().search(nums, target);
        System.out.println(res);
    }
}