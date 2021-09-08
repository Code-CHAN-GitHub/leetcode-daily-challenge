package com.leetcode.daily.y2021.m09;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @see <a href="https://leetcode-cn.com/problems/ipo/">ipo</a>
 */
public class d08_Q502 {

    class Project {
        int profit;
        int capital;
    }
    
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        Project[] projects = new Project[n];
        for (int i = 0; i < n; i++) {
            projects[i] = new Project();
            projects[i].profit = profits[i];
            projects[i].capital = capital[i];
        }
        Arrays.sort(projects, (a, b) -> a.capital - b.capital);
        PriorityQueue<Project> heap = new PriorityQueue<>((a, b) -> b.profit - a.profit);
        int i = 0;
        for (; i < n && w >= projects[i].capital; i++)
            heap.add(projects[i]);
        while (k-- > 0 && !heap.isEmpty()) {
            w += heap.poll().profit;
            for (; i < n && w >= projects[i].capital; i++)
                heap.add(projects[i]);   
        }
        return w;
    }

    public static void main(String[] args) {
        int k = 1;
        int w = 2;
        int[] profits = {1, 2, 3};
        int[] capital = {1, 1, 2};
        int res = new d08_Q502().findMaximizedCapital(k, w, profits, capital);
        System.out.println(res);
    }
}