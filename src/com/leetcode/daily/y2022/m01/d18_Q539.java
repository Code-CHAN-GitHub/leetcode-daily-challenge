package com.leetcode.daily.y2022.m01;

import java.util.List;
import java.util.TreeSet;

public class d18_Q539 {
    
    public int findMinDifference(List<String> timePoints) {
        TreeSet<Integer> set = new TreeSet<>();
        for (String time : timePoints) 
            if (!set.add(time2Sec(time))) 
                return 0;
        int max = 24 * 60;
        int pre = -1, min = max;
        for (int t : set) {
            if (pre == -1) {
                pre = t;
                continue;
            }
            min = Math.min(min, t - pre);
            pre = t;
        }
        min = Math.min(min, (set.first() + max - pre) % max);
        return min;
    }
    
    private int time2Sec(String s) {
        return (s.charAt(0) - '0') * 60 * 10 +
            (s.charAt(1) - '0') * 60 +
            (s.charAt(3) - '0') * 10 + 
            (s.charAt(4) - '0');
    }

    public static void main(String[] args) {
        
    }

}