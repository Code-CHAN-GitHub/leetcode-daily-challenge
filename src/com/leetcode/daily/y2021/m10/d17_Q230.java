package com.leetcode.daily.y2021.m10;

import com.leetcode.utils.treenode.TreeNode;
import com.leetcode.utils.treenode.TreeNodeWrapper;

class d17_Q230 {

    int ans;

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return ans;
    }

    private int dfs(TreeNode node, int k) {
        if (node == null)
            return 0;
        int l = dfs(node.left, k);
        if (l + 1 == k) {
            ans = node.val;
        }
        int r = dfs(node.right, k - l - 1);
        return l + r + 1;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeWrapper.stringToTreeNode("[5,3,6,2,4,null,null,1]");
        int k = 3;
        int res = new d17_Q230().kthSmallest(root, k);
        System.out.println(res);
    }

}