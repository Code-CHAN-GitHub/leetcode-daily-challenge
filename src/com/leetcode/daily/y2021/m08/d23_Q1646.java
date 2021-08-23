package com.leetcode.daily.y2021.m08;/**
 * @author chen
 * @create 2021-08-23-08:54
 */

/**
 *@ClassName d23_Q1646
 *@Description get-maximum-in-generated-array
 *Author chen
 *Date 2021/8/23 08:54
 *Version 1.0
 *@See <a href="https://leetcode-cn.com/problems/get-maximum-in-generated-array/">get-maximum-in-generated-array</a>
 **/
public class d23_Q1646 {

    public int getMaximumGenerated(int n) {
        if (n <= 1)
            return n;
        int[] nums = new int[n + 1];
        nums[1] = 1;
        int max = 0;
        for (int i = 2; i <= n; i++) {
            if ((i & 1) == 0) {
                nums[i] = nums[i / 2];
            } else {
                nums[i] = nums[i / 2] + nums[i / 2 + 1];
            }
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int n = 7;
        int res = new d23_Q1646().getMaximumGenerated(n);
        System.out.println(res);
    }
}
