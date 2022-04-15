package com.leetcode.daily.y2021.m12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class d26_Q1078 {

    public String[] findOcurrences(String text, String first, String second) {
        String[] ss = text.split(" ");
        List<String> list = new ArrayList<>();
        int i = 0;
        while (i < ss.length - 2) {
            if (ss[i].equals(first) && ss[i + 1].equals(second))
                list.add(ss[i + 2]);
            i++;
        }
        String[] ans = new String[list.size()];
        list.toArray(ans);
        return ans;
    }

    public static void main(String[] args) {
        String text = "jkypmsxd jkypmsxd kcyxdfnoa jkypmsxd kcyxdfnoa jkypmsxd kcyxdfnoa kcyxdfnoa jkypmsxd kcyxdfnoa";
        String first = "kcyxdfnoa";
        String second = "jkypmsxd";
        String[] res = new d26_Q1078().findOcurrences(text, first, second);
        System.out.println(Arrays.toString(res));
    }
    
}