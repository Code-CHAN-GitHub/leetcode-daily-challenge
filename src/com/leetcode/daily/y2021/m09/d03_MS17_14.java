package com.leetcode.daily.y2021.m09;

import java.util.Arrays;

/**
 * @See <a href="https://leetcode-cn.com/problems/smallest-k-lcci/">smallest-k-lcci</a>
 */
public class d03_MS17_14 {

    public int[] smallestK(int[] arr, int k) {
        quickSelect(arr, 0, arr.length - 1, k);
        int[] res = new int[k];
        for (int i = 0; i < k; i++)
            res[i] = arr[i];
        return res;
    }

    private void quickSelect(int[] arr, int left, int right, int k) {
        if (left >= right)
            return;
        if (left + 1 == right) {
            int small = Math.min(arr[left], arr[right]);
            int big = Math.max(arr[left], arr[right]);
            arr[left] = small;
            arr[right] = big;
            return;
        }

        int key = media3(arr, left, right);
        int i = left, j = right - 1;
        while (true) {
            while (arr[++i] < key) {};
            while (arr[--j] > key) {};
            if (i >= j)
                break;
            swap(arr, i, j);
        }
        swap(arr, i, right - 1);

        if (i == k - 1)
            return;
        else if (i < k - 1)
            quickSelect(arr, i + 1, right, k);
        else 
            quickSelect(arr, left, i - 1, k);
    }

    private int media3(int[] arr, int left, int right) {
        int mid = left + ((right - left) >> 1);
        if (arr[left] > arr[mid])
            swap(arr, left, mid);
        if (arr[left] > arr[right])
            swap(arr, left, right);
        if (arr[mid] > arr[right])
            swap(arr, mid, right);
        swap(arr, mid, right - 1);
        return arr[right - 1];
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 2, 4, 6, 8};
        int k = 4;
        int[] res = new d03_MS17_14().smallestK(arr, k);
        System.out.println(Arrays.toString(res));
    }
}