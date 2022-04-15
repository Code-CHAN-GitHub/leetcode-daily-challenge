package com.leetcode.daily.y2022.m01;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class d21_Q1345 {

    LinkedList<Integer> EMPTY_LIST = new LinkedList<>();
    
    public int minJumps(int[] arr) {
        int n = arr.length;
        Map<Integer,LinkedList<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(arr[i]))
                map.put(arr[i], new LinkedList<>());
            LinkedList<Integer> list = map.get(arr[i]);
            int nn = list.size();
            if (nn > 1 && i - 1 == list.get(nn - 1)) 
                list.pollLast();
            list.add(i);
        }
        Deque<Integer> deque = new ArrayDeque<>();
        boolean[] vis = new boolean[n];
        deque.add(0);
        vis[0] = true;
        int step = 0;
        while (!deque.isEmpty()) {
            int sz = deque.size();
            while (sz-- > 0) {
                int v = deque.poll();
                if (v == n - 1) return step;
                if (v - 1 > 0 && !vis[v - 1]) {
                    vis[v - 1] = true;
                    deque.add(v - 1);
                }
                if (v + 1 < n && !vis[v + 1]) {
                    vis[v + 1] = true;
                    deque.add(v + 1);
                }
                for (int w : map.getOrDefault(arr[v], EMPTY_LIST)) {
                    if (!vis[w]) {
                        vis[w] = true;
                        deque.add(w);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,11};
        int ret = new d21_Q1345().minJumps(arr);
    }
    
}