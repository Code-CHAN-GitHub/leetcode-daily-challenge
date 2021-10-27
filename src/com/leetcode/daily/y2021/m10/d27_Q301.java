package com.leetcode.daily.y2021.m10;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

class d27_Q301 {

    public List<String> removeInvalidParentheses(String s) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(s);
        Set<String> set = new HashSet<>();
        Set<String> vis = new HashSet<>();
        while (!queue.isEmpty() && set.isEmpty()) {
            int sz = queue.size();
            while (sz-- > 0) {
                String poll = queue.poll();
                if (check(poll))
                    set.add(poll);
                if (set.isEmpty()) {
                    for (int i = 0; i < poll.length(); i++) {
                        char c = poll.charAt(i);
                        if (c == '(' || c == ')') {
                            String next = poll.substring(0, i) + (i == poll.length() - 1 ? "" : poll.substring(i + 1));
                            if (!vis.contains(next)) {
                                queue.offer(next);
                                vis.add(next);
                            }
                        }
                    }
                }
            }
        }
        return set.stream().collect(Collectors.toList());
    }

    public boolean check(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') cnt++;
            else if (c == ')') cnt--;
            if (cnt < 0) return false;
        }
        return cnt == 0;
    }

    public static void main(String[] args) {
        String s = ")))))))))))))))))))))))))";
        List<String> res = new d27_Q301().removeInvalidParentheses(s);
        System.out.println(res);
    }

}