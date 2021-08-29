package com.leetcode.daily.y2021.m08;/**
 * @author chen
 * @create 2021-08-29-14:05
 */

/**
 *@ClassName d29_Q1588
 *@Description sum-of-all-odd-length-subarrays
 *Author chen
 *Date 2021/8/29 14:05
 *Version 1.0
 *@See <a href="https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays/">sum-of-all-odd-length-subarrays</a>
 **/
public class d29_Q1588 {

    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0, n = arr.length;
        for (int i = 0; i < n; i++) {
            int leftEven = (i + 1) / 2, rightEven = (n - i) / 2;
            int leftOdd = i / 2, rightOdd = (n - i - 1) / 2;
            leftOdd++; rightOdd++;
            sum += arr[i] * (leftEven * rightEven + leftOdd * rightOdd);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 5, 3};
        int res = new d29_Q1588().sumOddLengthSubarrays(arr);
        System.out.println(res);
    }
}
