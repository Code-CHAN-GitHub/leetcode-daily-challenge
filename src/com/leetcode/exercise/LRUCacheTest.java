package com.leetcode.exercise;

import java.util.*;

/**
 * @author chen
 * @create 2022-02-08-20:19
 */
public class LRUCacheTest {

    public String removeDuplicateLetters(String str) {
        char[] s = str.toCharArray();
        int[] cnts = new int[128];
        boolean[] inStack = new boolean[128];
        for (char c : s)
            cnts[c]++;
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s) {
            if (inStack[c]) {
                cnts[c]--;
                continue;
            }
            while (!stack.isEmpty() && !inStack[c] && c < stack.peek() && cnts[stack.peek()] > 1) {
                char top = stack.pop();
                inStack[top] = false;
                cnts[top]--;
            }
            stack.push(c);
            inStack[c] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.pop());
        return sb.reverse().toString();
    }


    public static void main(String[] args) {
        String s = "bbcaac";
        System.out.println(new LRUCacheTest().removeDuplicateLetters(s));
        
    }
}
