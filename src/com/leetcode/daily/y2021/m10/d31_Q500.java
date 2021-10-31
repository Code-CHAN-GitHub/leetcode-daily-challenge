package com.leetcode.daily.y2021.m10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class d31_Q500 {

    static char[][] keybord = {
        {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'},
        {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'},
        {'z', 'x', 'c', 'v', 'b', 'n', 'm'}
    };

    static int[] map = new int[26];
    
    static {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < keybord[i].length; j++) {
                map[keybord[i][j] - 'a'] = i;
            }
        }
    }

    public String[] findWords(String[] words) {
        List<String> list = new ArrayList<>();
        for (String word : words) {
            int r = map[Character.toLowerCase(word.charAt(0)) - 'a'];
            boolean flag = true;
            for (int i = 1; i < word.length(); i++) {
                if (map[Character.toLowerCase(word.charAt(i)) - 'a'] != r) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                list.add(word);
        }
        return list.toArray(new String[list.size()]);
    }
    
    public static void main(String[] args) {
        String[] words = {"Hello","Alaska","Dad","Peace"};
        String[] res = new d31_Q500().findWords(words);
        System.out.println(Arrays.toString(res));
    }

}
