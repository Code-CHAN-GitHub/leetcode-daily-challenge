package com.leetcode.daily.y2021.m10;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class d26_Q496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stk = new Stack<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums2) {
            while (!stk.isEmpty() && num > stk.peek()) {
                map.put(stk.pop(), num);
            }
            stk.push(num);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 4};
        int[] nums2 = {1, 2, 3, 4};
        int[] res = new d26_Q496().nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }

}