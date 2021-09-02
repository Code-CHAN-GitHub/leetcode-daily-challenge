package com.leetcode.daily.y2021.m09;

/**
 * @See <a href="https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/">lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof</a>
 */
public class d02_Offer22 {
    
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    private int t;

    public ListNode getKthFromEnd(ListNode head, int k) {
        return dfs(head, k);
    }

    private ListNode dfs(ListNode head, int k) {
        if (head == null)
            return head;
        ListNode res = dfs(head.next, k);
        if (k == ++t)
            res = head;
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode dummy = new d02_Offer22().new ListNode(0);
        ListNode p = dummy;
        for (int val : arr) {
            p.next = new d02_Offer22().new ListNode(val);
            p = p.next;
        }
        int k = 2;
        ListNode res = new d02_Offer22().getKthFromEnd(dummy.next, k);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}