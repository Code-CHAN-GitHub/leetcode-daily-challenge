package com.leetcode.daily.y2022.m01;

import java.util.Random;

import com.leetcode.utils.list.ListNode;
import com.leetcode.utils.list.ListNodeWrapper;

public class d16_Q382 {

    class Solution {
    
        ListNode head;
        Random random = new Random();
        
        public Solution(ListNode head) {
            this.head = head;
        }
        
        public int getRandom() {
            int k = 0, ans = 0;
            ListNode p = head;
            while (p != null) {
                if (random.nextInt(++k) == 0) 
                    ans = p.val;
                p = p.next;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        ListNode head = ListNodeWrapper.stringToListNode("[1, 2, 3]");
        Solution solution = new d16_Q382().new Solution(head);
        for (int i = 0; i < 5; i++) {
            System.out.println(solution.getRandom());
        }
    }
    
}