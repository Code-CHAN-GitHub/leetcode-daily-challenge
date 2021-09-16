package com.leetcode.daily.y2021.m09;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class d16_Q212 {

    
    class TrieNode {
        String str;
        Map<Character, TrieNode> children = new HashMap<>();
    }

    TrieNode root = new TrieNode();
    
    Set<String> set = new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {
        for (String word : words) 
            buildTrie(word);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(root, board, i, j);   
            }
        }
        List<String> ans = new ArrayList<>(set);
        return ans;   
    }

    private void dfs(TrieNode node, char[][] board, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length)
            return;
        if (!node.children.containsKey(board[x][y]))
            return;

        node = node.children.get(board[x][y]);
        if (node.str != null)
            set.add(node.str);

        char tmp = board[x][y];
        board[x][y] = '#';

        dfs(node, board, x + 1, y);
        dfs(node, board, x - 1, y);
        dfs(node, board, x, y + 1);
        dfs(node, board, x, y - 1);

        board[x][y] = tmp;
    }
    
    private void buildTrie(String word) {
        TrieNode cur = root;
        char[] s = word.toCharArray();
        for (char c : s) {
            if (!cur.children.containsKey(c))
                cur.children.put(c, new TrieNode());
            cur = cur.children.get(c);
        }
        cur.str = word;
    }


    public static void main(final String[] args) {
        final char[][] board = {
            {'o', 'a', 'a', 'n'}, 
            {'e', 't', 'a', 'e'},
            {'i', 'h', 'k', 'r'},
            {'i', 'f', 'l', 'v'}
        };
        final String[] words = {"eat", "oath"};
        final List<String> res = new d16_Q212().findWords(board, words);
        System.out.println(res);
    }
    
}