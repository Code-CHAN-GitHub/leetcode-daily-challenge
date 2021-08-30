package com.leetcode.daily.y2021.m08;/**
 * @author chen
 * @create 2021-08-30-09:36
 */

import java.util.Random;

/**
 *@ClassName d30_Q528
 *@Description TODO
 *Author chen
 *Date 2021/8/30 09:36
 *Version 1.0
 **/
public class d30_Q528 {

    class Solution {

        private Random rand = new Random();

        private int[] w;

        public Solution(int[] w) {
            this.w = w;
            for (int i = 1; i < w.length; i++) {
                w[i] += w[i - 1];
            }
        }

        public int pickIndex() {
            int key = rand.nextInt(w[w.length - 1]);
            int left = 0, right = w.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (w[mid] <= key)
                    left = mid + 1;
                else
                    right = mid - 1;
            }
            return left;
        }
    }

    public static void main(String[] args) {
        int[] w = {1};
        Solution solution = new d30_Q528().new Solution(w);
        int index = solution.pickIndex();
        System.out.println(index);
    }
}
