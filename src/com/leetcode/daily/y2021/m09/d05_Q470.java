package com.leetcode.daily.y2021.m09;

import java.util.Arrays;
import java.util.Random;

/**
 * @see <a href="https://leetcode-cn.com/problems/implement-rand10-using-rand7/">implement-rand10-using-rand7</a>
 */
public class d05_Q470 {

    int[][] a = {
        {1, 1, 1, 1, 2, 2, 2},
        {2, 3, 3, 3, 3, 4, 4},
        {4, 4, 5, 5, 5, 5, 6},
        {6, 6, 6, 7, 7, 7, 7},
        {8, 8, 8, 8, 9, 9, 9},
        {9, 10, 10, 10, 10, 0, 0},
        {0, 0, 0, 0, 0, 0, 0}
    };

    public int rand10() {
        while (true) {
            int i = rand7() - 1;
            int j = rand7() - 1;
            if (a[i][j] != 0)
                return a[i][j];
        }
    }

    public static void main(String[] args) {
        d05_Q470 d05_Q470 =  new d05_Q470();
        int n = 10000000;
        int[] count = new int[11];
        while (n-- > 0) {
            int x = d05_Q470.rand10();
            count[x]++;
        }
        System.out.println(Arrays.toString(count));
    }

    private Random random = new Random();

    private int rand7() {
        return random.nextInt(6) + 1;
    }
}