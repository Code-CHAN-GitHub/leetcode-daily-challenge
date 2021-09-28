package com.leetcode.daily.y2021.m09;

import java.util.HashMap;
import java.util.Map;

import com.leetcode.utils.treenode.TreeNode;
import com.leetcode.utils.treenode.TreeNodeWrapper;

class d28_Q437 {

    /*
        前缀和、hashMap 优化
     */

    Map<Integer,Integer> map = new HashMap<>();

    int targetSum, ans;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        this.targetSum = targetSum;
        map.put(0, 1);
        dfs(root, root.val);
        return ans;
    }

    public void dfs(TreeNode node, int val) {
        if (map.containsKey(val - targetSum))
            ans += map.get(val - targetSum);
        map.put(val, map.getOrDefault(val, 0) + 1);
        if (node.left != null)
            dfs(node.left, val + node.left.val);
        if (node.right != null)
            dfs(node.right, val + node.right.val);
        map.put(val, map.getOrDefault(val, 0) - 1);
    }

    /*
        前缀和
    */
    // int ans = 0;
    
    // public int pathSum(TreeNode root, int targetSum) {
    //     int[] preSum = new int[1001];
    //     dfs(root, preSum, 1, targetSum);
    //     return ans;
    // }
    
    // private void dfs(TreeNode node, int[] preSum, int i, int targetSum) {
    //     if (node == null)
    //         return;
    //     preSum[i] = node.val + preSum[i - 1];
    //     for (int j = 0; j < i; j++)
    //         if (preSum[i] - preSum[j] == targetSum)
    //             ans++;
    //     dfs(node.left, preSum, i + 1, targetSum);
    //     dfs(node.right, preSum, i + 1, targetSum);
    // }

    public static void main(String[] args) {
        TreeNode root = TreeNodeWrapper.stringToTreeNode("[10,5,-3,3,2,null,11,3,-2,null,1]");
        int targetSum = 8;
        int res = new d28_Q437().pathSum(root, targetSum);
        System.out.println(res);
    }

}