package com.leetcode.daily.y2021.m10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


class d09_352 {

    class SummaryRanges {

    
        private class Node {
            int l, r;
            public Node(int l, int r) {this.l = l; this.r = r;}
        }
        
        private LinkedList<Node> nodes;
        private int[][] cache;
        private boolean isDirty = true;
        private int min, max;
        
        public SummaryRanges() {
            nodes = new LinkedList<>();
        }
        
        public void addNum(int val) {
            if (nodes.isEmpty()) {
                nodes.add(new Node(val, val));
                min = max = val;
                getIntervals();
                return;
            }
            if (val < min) {
                if (val == min - 1) {
                    nodes.getFirst().l--;
                    cache[0][0]--;
                }
                else { 
                    isDirty = true;
                    nodes.addFirst(new Node(val, val));
                }
                min = val;
            } else if (val > max) {
                if (val == max + 1) {
                    nodes.getLast().r++;
                    cache[cache.length - 1][1]++;
                }
                else {
                    isDirty = true;
                    nodes.add(new Node(val, val));
                }
                max = val;  
            } else if (val > min && val < max) {
                if (isDirty) getIntervals();
                int idx = leftSearch(val);
                if (idx == -1) return;

                Node lo = nodes.get(idx), hi = nodes.get(idx + 1);
                if (lo.r + 1 == val && hi.l - 1 == val) {
                    lo.r = hi.r;
                    nodes.remove(idx + 1);
                    isDirty = true;
                } else if (lo.r + 1 == val) {
                    lo.r++;
                    cache[idx][1]++;
                } else if (hi.l - 1 == val) {
                    hi.l--;
                    cache[idx + 1][0]--;
                } else if (val < hi.l && val > lo.r) {
                    nodes.add(idx + 1, new Node(val, val));
                    isDirty = true;
                }
            }
        }
        
        private int leftSearch(int target) {
            int left = 0, right = cache.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (cache[mid][1] == target)
                    return mid;
                else if (cache[mid][1] > target)
                    right = mid;
                else 
                    left = mid + 1;
            }
            return right - 1;
        }
        
        public int[][] getIntervals() {
            if (!isDirty) return cache;
            cache = new int[nodes.size()][2];
            for (int i = 0; i < cache.length; i++) { 
                Node node = nodes.get(i);
                cache[i][0] = node.l;
                cache[i][1] = node.r;
            }
            isDirty = false;
            return cache;
        }
    
    }

    public static void main(String[] args) {
        SummaryRanges sRanges = new d09_352().new SummaryRanges();
        sRanges.addNum(1);
        printArr(sRanges.getIntervals());
        sRanges.addNum(3);
        printArr(sRanges.getIntervals());
        sRanges.addNum(7);
        printArr(sRanges.getIntervals());
        sRanges.addNum(2);
        printArr(sRanges.getIntervals());
        sRanges.addNum(6);
        printArr(sRanges.getIntervals());
    }

    private static void printArr(int[][] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("[%d, %d],", arr[i][0], arr[i][1]);
        }
        System.out.print("\b]\n");
    }
}