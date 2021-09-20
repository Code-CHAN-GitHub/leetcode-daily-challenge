package com.leetcode.daily.y2021.m09;

import java.util.ArrayList;

public class d20_Q673 {

    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        ArrayList<int[]>[] arr = new ArrayList[n];
        for (int i = 0; i < n; i++)
            arr[i] = new ArrayList<>();
        arr[0].add(new int[]{nums[0], 0, 0});
        int sz = 1;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            int left = 0, right = sz - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (arr[mid].get(arr[mid].size() - 1)[0] >= num)
                    right = mid - 1;
                else 
                    left = mid + 1;
            }
            if (left == sz)
                sz++;
            arr[left].add(new int[]{num, i, 0});
        }

        for (int i = 0; i < arr[sz - 1].size(); i++)
            arr[sz - 1].get(i)[2] = 1;

        for (int i = sz - 2; i >= 0; i--) {
            for (int[] ints : arr[i]) {
                int left = 0, right = arr[i + 1].size() - 1;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (arr[i + 1].get(mid)[1] >= ints[1])
                        right = mid - 1;
                    else
                        left = mid + 1;
                }
                int lo = right + 1;
                left = lo;
                right = arr[i + 1].size() - 1;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (arr[i + 1].get(mid)[0] <= ints[0])
                        right = mid - 1;
                    else 
                        left = mid + 1;
                }
                int hi = left - 1;
                
                for (int j = lo; j <= hi; j++) {
                    ints[2] += arr[i + 1].get(j)[2];
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < arr[0].size(); i++) {
            ans += arr[0].get(i)[2];
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2,34,1,241,234,12,312,3,123,12,31,23,12,3,123,1,42,15243};
        int res = new d20_Q673().findNumberOfLIS(nums);
        System.out.println(res);
    }
    
}