package com.leetcode.collect.合并区间;

import java.util.Arrays;

public class Collect_Q56 {
    
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int n = intervals.length, idx = 0;
        int[][] ans = new int[n][];
        ans[0] = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] val = intervals[i];
            if (val[0] <= ans[idx][1])
                ans[idx][1] = Math.max(ans[idx][1], val[1]);
            else 
                ans[++idx] = val;
        }
        return Arrays.copyOf(ans, idx + 1);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] ret = new Collect_Q56().merge(intervals);
        Arrays.stream(ret).forEach(item -> System.out.println(Arrays.toString(item)));
    }

}