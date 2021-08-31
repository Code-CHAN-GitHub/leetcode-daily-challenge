package com.leetcode.daily.y2021.m08;/**
 * @author chen
 * @create 2021-08-31-10:04
 */

import java.util.Arrays;

/**
 *@ClassName d31_1109
 *@Description corporate-flight-bookings
 *Author chen
 *Date 2021/8/31 10:04
 *Version 1.0
 *@See <a href="https://leetcode-cn.com/problems/corporate-flight-bookings/">corporate-flight-bookings</a>
 **/
public class d31_1109 {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] d = new int[n + 1];
        for (int[] book : bookings) {
            d[book[0]] += book[2];
            if (book[1] != n) {
                d[book[1] + 1] -= book[2];
            }
        }
        int[] res = new int[n];
        res[0] = d[1];
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] + d[i + 1];
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] bookings = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        int n = 5;
        int[] res = new d31_1109().corpFlightBookings(bookings, n);
        System.out.println(Arrays.toString(res));
    }
}
