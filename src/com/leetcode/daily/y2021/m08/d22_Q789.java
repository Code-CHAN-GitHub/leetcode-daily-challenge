package com.leetcode.daily.y2021.m08;/**
 * @author chen
 * @create 2021-08-22-21:30
 */

/**
 *@ClassName d22_Q789
 *@Description escape-the-ghosts
 *Author chen
 *Date 2021/8/22 21:30
 *Version 1.0
 *@See <a href="https://leetcode-cn.com/problems/escape-the-ghosts/">escape-the-ghosts</a>
 **/
public class d22_Q789 {

    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        if (target[0] == 0 && target[1] == 1)
            return true;
        int d = distance(new int[]{0, 0}, target);
        for (int[] ghost : ghosts) {
            if (distance(ghost, target) <= d) {
                return false;
            }
        }
        return true;
    }

    private int distance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }

    public static void main(String[] args) {
        int[][] ghosts = {{1, 0}, {0, 3}};
        int[] target = {0, 1};
        boolean res = new d22_Q789().escapeGhosts(ghosts, target);
        System.out.println(res);
    }

}
