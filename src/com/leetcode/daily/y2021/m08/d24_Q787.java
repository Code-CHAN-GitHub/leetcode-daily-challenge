package com.leetcode.daily.y2021.m08;/**
 * @author chen
 * @create 2021-08-24-10:08
 */

import java.lang.reflect.Array;
import java.util.*;

/**
 *@ClassName d24_Q787
 *@Description TODO
 *Author chen
 *Date 2021/8/24 10:08
 *Version 1.0
 **/
public class d24_Q787 {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] g = new int[n][n];
        int INF = 0x3f3f3f;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = i == j ? 0 : INF;
            }
        }
        for (int[] flight : flights) {
            g[flight[0]][flight[1]] = flight[2];
        }
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[src] = 0;
        while (k-- > 0) {
            int[] clone = dist.clone();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (g[i][j] + clone[i] < clone[j]) {
                        dist[j] = g[i][j] + clone[i];
                    }
                }
            }
        }
        return dist[dst] > INF / 2 ? -1 : dist[dst];
    }



    public static void main(String[] args) {
        int n = 3;
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        int src = 0, dst = 2;
        int k = 0;
        int res = new d24_Q787().findCheapestPrice(n, flights, src, dst, k);
        System.out.println(res);
    }
}
