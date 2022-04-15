package com.leetcode.exercise;

import com.leetcode.utils.list.ListNode;
import com.leetcode.utils.list.ListNodeWrapper;

public class OddEvenList {

    public static ListNode sort(ListNode head) {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
        ListNode p = l1, q = l2;
        boolean flag = true;
        while (head != null) {
            if (flag) {
                p.next = head;
                p = p.next;
            } else {
                q.next = head;
                q = q.next;
            }
            head = head.next;
            flag = !flag;
        }
        p.next = q.next = null;
        l2.next = reverse(l2.next);
        ListNode dummy = new ListNode(0);
        p = dummy;
        l1 = l1.next; l2 = l2.next;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null) p.next = l1;
        if (l2 != null) p.next = l2;
        return dummy.next;
    } 

    private static ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }  

    public static void main(String[] args) {
        ListNode head = ListNodeWrapper.stringToListNode("[1,8,3,6,5,4,7,2]");
        ListNode res = sort(head);
        ListNodeWrapper.prettyPrintLinkedList(res);
    }
    
}