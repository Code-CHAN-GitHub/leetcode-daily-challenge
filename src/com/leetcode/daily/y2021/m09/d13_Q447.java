package com.leetcode.daily.y2021.m09;

import java.util.HashMap;
import java.util.Map;

public class d13_Q447 {

    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Integer,Integer> map = new HashMap<>();
            int x = points[i][0], y = points[i][1];
            for (int j = 0; j < points.length; j++) {
                if (j != i) {
                    int d = distance(x, y, points[j][0], points[j][1]);
                    map.put(d, map.getOrDefault(d, 0) + 1);
                }
            }
            for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
                int n = entry.getValue();
                if (n > 1) {
                    res += n * (n - 1);
                }
            }
        }
        return res;
    }
    
    private int distance(int x1, int y1, int x2, int y2) {
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2); 
    }

    public static void main(String[] args) {
        int[][] points = {{0, 0}, {1, 0}, {2, 0}, {1, 1}};
        int res = new d13_Q447().numberOfBoomerangs(points);
        System.out.println(res);
    }
    
}