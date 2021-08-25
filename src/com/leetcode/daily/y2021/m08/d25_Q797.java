package com.leetcode.daily.y2021.m08;/**
 * @author chen
 * @create 2021-08-25-09:19
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *@ClassName d25_Q797
 *@Description all-paths-from-source-to-target
 *Author chen
 *Date 2021/8/25 09:19
 *Version 1.0
 *@See <a href="https://leetcode-cn.com/problems/all-paths-from-source-to-target/">all-paths-from-source-to-target</a>
 **/
public class d25_Q797 {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        LinkedList<Integer> path = new LinkedList<>();
        path.add(0);
        dfs(0, graph, path);
        return res;
    }

    private void dfs(int cur, int[][] graph, LinkedList<Integer> path) {
        int n = graph.length;
        if (cur == n - 1) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int adj : graph[cur]) {
            path.add(adj);
            dfs(adj, graph, path);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {3}, {3}, {}};
        List<List<Integer>> res = new d25_Q797().allPathsSourceTarget(graph);
        System.out.println(res);
    }
}
