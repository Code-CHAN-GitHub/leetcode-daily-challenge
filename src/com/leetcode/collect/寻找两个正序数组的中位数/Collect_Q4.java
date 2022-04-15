package com.leetcode.collect.寻找两个正序数组的中位数;

public class Collect_Q4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        return (getKth(nums1, 0, m - 1, nums2, 0, n - 1, (m + n + 1) / 2) +
               getKth(nums1, 0, m - 1, nums2, 0, n - 1, (m + n + 2) / 2)) * 0.5;
    }
    
    private int getKth(int[] nums1, int start1, int end1,
                      int[] nums2, int start2, int end2, int kth) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, kth);
        if (len1 == 0) return nums2[start2 + kth - 1];
        if (kth == 1) return Math.min(nums1[start1], nums2[start2]);
        
        int i = Math.min(len1, kth / 2) + start1 - 1;
        int j = Math.min(len2, kth / 2) + start2 - 1;
        if (nums1[i] < nums2[j])
            return getKth(nums1, i + 1, end1, nums2, start2, end2, kth - (i - start1 + 1));
        else 
            return getKth(nums1, start1, end1, nums2, j + 1, end2, kth - (j - start2 + 1));
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double ret = new Collect_Q4().findMedianSortedArrays(nums1, nums2);
        System.out.println(ret);
    }
}