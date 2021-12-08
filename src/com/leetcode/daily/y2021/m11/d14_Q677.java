package com.leetcode.daily.y2021.m11;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class d14_Q677 {

    class MapSum {

        class TrieNode {
            boolean end;
            int val;
            Map<Character, TrieNode> children = new HashMap<>();
        }

        TrieNode root = new TrieNode();

        public MapSum() {
    
        }
        
        public void insert(String key, int val) {
            char[] s = key.toCharArray();
            TrieNode cur = root;
            for (int i = 0; i < s.length; i++) {
                if (!cur.children.containsKey(s[i]))
                    cur.children.put(s[i], new TrieNode());
                cur = cur.children.get(s[i]);
            }
            cur.end = true;
            cur.val = val;
        }

        public int sum(String prefix) {
            TrieNode cur = root;
            char[] s = prefix.toCharArray();
            for (int i = 0; i < s.length; i++) {
                if (!cur.children.containsKey(s[i]))
                    return 0;
                cur = cur.children.get(s[i]);
            }
            return dfs(cur);
        }

        private int dfs(TrieNode node) {
            if (node == null)
                return 0;
            int res = node.val;
            Iterator<TrieNode> it = node.children.values().iterator();
            while (it.hasNext()) {
                res += dfs(it.next());
            }
            return res;
        }
    }

    /**
     * appled
     * 222222
     * 555552
     * 444442
     */
    public static void main(String[] args) {
        MapSum mapSum = new d14_Q677().new MapSum();
        mapSum.insert("appled", 2);
        int sum1 = mapSum.sum("ap");
        System.out.println(sum1);
        mapSum.insert("apple", 3);
        mapSum.insert("apple", 2);
        int sum2 = mapSum.sum("a");
        System.out.println(sum2);
    }

}