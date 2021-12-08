package com.leetcode.daily.y2021.m11;

class d17_Q318 {

    public int maxProduct(String[] words) {
        int n = words.length;
        int[] len = new int[n];
        int[] book = new int[n];
        for (int i = 0; i < n; i++) {
            String s = words[i];
            for (int j = 0; j < s.length() && len[i] < 26; j++) {
                int t = 1 << (s.charAt(j) - 'a');
                if ((t & book[i]) == 0) {
                    len[i]++;
                    book[i] |= t;
                }
            }
            // System.out.println(Integer.toBinaryString(book[i]));
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((book[i] & book[j]) == 0) {
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String[] words = {"eae","ea","aaf","bda","fcf","dc","ac","ce","cefde","dabae"};
        int res = new d17_Q318().maxProduct(words);
        System.out.println(res);
    }
    
}