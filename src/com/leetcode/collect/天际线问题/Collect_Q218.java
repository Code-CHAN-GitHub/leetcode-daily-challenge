package com.leetcode.collect.天际线问题;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Collect_Q218 {
    
    class Point {
        int x, h;
        public Point(int x, int h) {
            this.x = x;
            this.h = h;
        }
    }
    
    public List<List<Integer>> getSkyline(int[][] buildings) {
        Arrays.sort(buildings, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            if (a[2] != a[2]) return b[2] - a[2];
            return b[1] - a[1];
        });
        LinkedList<Point> points = new LinkedList<>();
        points.add(new Point(-1, 0));
        for (int[] building : buildings) {
            int l = building[0], r = building[1], h = building[2];
            if (points.isEmpty() || l > points.peekLast().x) {
                points.add(new Point(l, h));
                points.add(new Point(r, 0));
            } else {
                int i = points.size() - 1;
                Point[] pp = new Point[3];
                int[] idxs = new int[3];
                while (i > 0) {
                    Point p1 = points.get(i - 1), p2 = points.get(i);
                    if (p2.x < l) break;
                    if (l <= p2.x && r > p2.x && h > p2.h) {
                        pp[0] = new Point(p2.x, h);
                        idxs[0] = i;
                    } 
                    if (p1.x < r && r < p2.x && h > p1.h) {
                        pp[1] = new Point(r, p1.h);
                        idxs[1] = i;
                    }
                    if (p1.x < l && l < p2.x && h > p1.h) {
                        pp[2] = new Point(l, h);
                        idxs[2] = i;
                    }
                    i--;
                }
                int removeIdx = -1;
                for (i = 0; i < 3; i++) {
                    if (pp[i] != null) {
                        if (points.get(idxs[i]).x == pp[i].x) {
                            points.get(idxs[i]).h = pp[i].h;
                            if (points.get(idxs[i]).h == points.get(idxs[i] - 1).h)
                                removeIdx = idxs[i];
                        }
                        else points.add(idxs[i], pp[i]);
                    }
                }
                if (pp[1] == null && r > points.peekLast().x) {
                    if (points.peekLast().h == 0) points.peekLast().x = r;
                    else points.addLast(new Point(r, 0));
                }
                if (removeIdx != -1) points.remove(removeIdx);
            }
        }
        points.pollFirst();
        return points.stream()
            .map(p -> Arrays.asList(p.x, p.h))
            .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        // int[][] buildings = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        int[][] buildings = {{0, 2, 3}, {2, 5, 3}};
        // int[][] buildings = {{1, 2, 1}, {1, 2, 2}, {1, 2, 3}, {2, 3, 1}, {2, 3, 2}, {2, 3, 3}};
        List<List<Integer>> ret = new Collect_Q218().getSkyline(buildings);
        System.out.println(ret);
    }

}