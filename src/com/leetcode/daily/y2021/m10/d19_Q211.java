package com.leetcode.daily.y2021.m10;

import java.util.HashMap;
import java.util.Map;

public class d19_Q211 {

    class WordDictionary {

        class TrieNode {
            boolean isEnd;
            Map<Character, TrieNode> children = new HashMap<>();
        }
    
        TrieNode root = new TrieNode();
    
        public WordDictionary() {
            
        }
        
        public void addWord(String word) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!cur.children.containsKey(c))
                    cur.children.put(c, new TrieNode());
                cur = cur.children.get(c);
            }
            cur.isEnd = true;
        }
        
        public boolean search(String word) {
            return dfs(root, word.toCharArray(), 0);
        }
    
        private boolean dfs(TrieNode node, char[] s, int i) {
            if (i == s.length) {
                return node.isEnd;
            }
            boolean res = false;
            if (s[i] == '.') {
                for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
                    res |= dfs(entry.getValue(), s, i + 1);
                    if (res) 
                        break;
                }
            } else if (node.children.containsKey(s[i])) {
                res |= dfs(node.children.get(s[i]), s, i + 1);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        WordDictionary wDict = new d19_Q211().new WordDictionary();
        wDict.addWord("bad");
        wDict.addWord("dad");
        wDict.addWord("mad");
        System.out.println(wDict.search("pad"));
        System.out.println(wDict.search("bad"));
        System.out.println(wDict.search(".ad"));
        System.out.println(wDict.search("b.."));
    }
    
}