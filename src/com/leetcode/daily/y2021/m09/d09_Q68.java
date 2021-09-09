package com.leetcode.daily.y2021.m09;

import java.util.ArrayList;
import java.util.List;

public class d09_Q68 {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.length; ) {
            int width = words[i].length();
            int j = i + 1;
            for (; j < words.length; j++) {
                if (width + words[j].length() + 1 > maxWidth)
                    break;
                width += words[j].length() + 1;
            }
            
            StringBuilder sb = new StringBuilder(words[i]);
            int surplusWidth = maxWidth - (width - j + i + 1);
            
            int k = i + 1, n;
            while ((n = j - k) > 0) {
                int len = j == words.length ? 1 : surplusWidth / n;
                if (j != words.length && surplusWidth % n != 0)
                    len++;
                appendNSpace(sb, len);
                sb.append(words[k++]);
                surplusWidth -= len;
            }
            appendNSpace(sb, maxWidth - sb.length());
        
            i = j;
            res.add(sb.toString());
        }
        return res;
    }
    
    private void appendNSpace(StringBuilder sb, int n) {
        for (int i = 0; i < n; i++)
            sb.append(" ");
    }

    public static void main(String[] args) {
        String[] words = {"What","must","be","acknowledgment","shall","be"};
        int maxWidth = 16;
        List<String> res = new d09_Q68().fullJustify(words, maxWidth);
        System.out.println(res);
    }
    
}