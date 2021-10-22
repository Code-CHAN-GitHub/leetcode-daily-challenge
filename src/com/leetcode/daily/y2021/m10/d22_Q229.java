package com.leetcode.daily.y2021.m10;

import java.util.ArrayList;
import java.util.List;

class d22_Q229 {

    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int a = 0, b = 0;
        int c1 = 0, c2 = 0;
        for (int i : nums) {
            if (c1 != 0 && a == i) c1++;
            else if (c2 != 0 && b == i) c2++;
            else if (c1 == 0 && ++c1 > 0) a = i;
            else if (c2 == 0 && ++c2 > 0) b = i;
            else {
                c1--; c2--;
            }
        }
        c1 = 0; c2 = 0;
        for (int i : nums) {
            if (a == i) c1++;
            else if (b == i) c2++;
        }
        List<Integer> ans = new ArrayList<>();
        if (c1 > n / 3) ans.add(a);
        if (c2 > n / 3) ans.add(b);
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,3,4,1,1,5,6,7,1,1,8,9,10,1,11,12,13,14};
        List<Integer> res = new d22_Q229().majorityElement(nums);
        System.out.println(res);
    }

}