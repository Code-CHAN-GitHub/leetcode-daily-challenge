package com.leetcode.daily.y2021.m09;

import com.leetcode.utils.list.ListNode;
import com.leetcode.utils.list.ListNodeWrapper;

class d22_Q725 {

    public ListNode[] splitListToParts(ListNode head, int k) {
        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }
        
        ListNode[] ans = new ListNode[k];
        int i = 0;
        while (len > 0) {
            int s = len / k;
            if (len % k != 0)
                s++;
            p = head;
            len -= s;
            while (--s > 0) {
                p = p.next;
            }
            ans[i++] = head;
            head = p.next;
            p.next = null;
            k--;
        }
        
        return ans;
    }

    public static void main(String[] args) {
        ListNode head = ListNodeWrapper.stringToListNode("[1,2,3,4,5,6,7,8,9,10]");
        int k = 3;
        ListNode[] res = new d22_Q725().splitListToParts(head, k);
        for (ListNode node : res) {
            ListNodeWrapper.prettyPrintLinkedList(node);
        }
    }

}