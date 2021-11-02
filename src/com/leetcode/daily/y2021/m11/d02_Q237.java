package com.leetcode.daily.y2021.m11;

import com.leetcode.utils.list.ListNode;
import com.leetcode.utils.list.ListNodeWrapper;

class d02_Q237 {
    
    public void deleteNode(ListNode node) {
        while (node.next.next != null) {
            node.val = node.next.val;
            node = node.next;
        }
        node.val = node.next.val;
        node.next = null;
    }

    public static void main(String[] args) {
        ListNode head = ListNodeWrapper.stringToListNode("[4,5,1,9]");
        new d02_Q237().deleteNode(head.next);
        ListNodeWrapper.prettyPrintLinkedList(head);
    }

}