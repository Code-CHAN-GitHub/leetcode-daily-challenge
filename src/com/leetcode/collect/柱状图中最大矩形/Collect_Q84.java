package com.leetcode.collect.柱状图中最大矩形;

import java.util.ArrayDeque;
import java.util.Deque;

public class Collect_Q84 {
    

    public int largestRectangleArea(int[] heights) {
        Deque<Integer> deque = new ArrayDeque<>();
        int n = heights.length, max = 0;
        for (int i = 0; i < n; i++) {
            if (deque.isEmpty() || heights[i] >= heights[deque.peekLast()])
                deque.add(i);
            else {
                while (!deque.isEmpty() && heights[deque.peekLast()] >= heights[i]) {
                    int j = deque.pollLast();
                    int r = i, l = deque.isEmpty() ? -1 : deque.peekLast();
                    max = Math.max(max, (r - l - 1) * heights[j]);
                } 
                deque.add(i);
            }
        }
        int r = n;
        while (!deque.isEmpty()) {
            int j = deque.pollLast();
            int l = deque.isEmpty() ? -1 : deque.peekLast();
            max = Math.max(max, (r - l - 1) * heights[j]);
        }
        return max;
    }

}