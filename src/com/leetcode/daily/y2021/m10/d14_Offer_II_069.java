package com.leetcode.daily.y2021.m10;

class d14_Offer_II_069 {

    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int left = 0, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid == 0 || mid == n - 1)
                return mid;
            else if (arr[mid] < arr[mid + 1])
                left = mid + 1;
            else if (arr[mid - 1] > arr[mid])
                right = mid;
            else 
                return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 4, 2};
        int res = new d14_Offer_II_069().peakIndexInMountainArray(arr);   
        System.out.println(res);
    }

}