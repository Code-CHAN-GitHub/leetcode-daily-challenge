package com.leetcode.daily.y2021.m08;/**
 * @author chen
 * @create 2021-08-26-10:15
 */

import java.util.Arrays;

/**
 *@ClassName d26_Q881
 *@Description boats-to-save-people
 *Author chen
 *Date 2021/8/26 10:15
 *Version 1.0
 *@See <a href="https://leetcode-cn.com/problems/boats-to-save-people/">boats-to-save-people</a>
 **/
public class d26_Q881 {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0, right = people.length - 1;
        int res = 0;
        while (left <= right) {
            int sum = people[left] + people[right];
            if (sum <= limit) {
                left++;
                right--;
            } else {
                right--;
            }
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] people = {1, 2};
        int limit = 3;
        int res = new d26_Q881().numRescueBoats(people, limit);
        System.out.println(res);
    }
}
