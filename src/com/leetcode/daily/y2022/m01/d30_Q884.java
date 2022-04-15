package com.leetcode.daily.y2022.m01;

import java.util.*;

/**
 * @author chen
 * @create 2022-01-30-10:08
 */
public class d30_Q884 {

    public String[] uncommonFromSentences(String s1, String s2) {
        List<String> list = new ArrayList<>();
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for (String s : s1.split(" ")) map1.put(s, map1.getOrDefault(s, 0) + 1);
        for (String s : s2.split(" ")) map2.put(s, map2.getOrDefault(s, 0) + 1);
        for (Map.Entry<String, Integer> entry : map1.entrySet())
            if (entry.getValue() == 1 && !map2.containsKey(entry.getKey()))
                list.add(entry.getKey());
        for (Map.Entry<String, Integer> entry : map2.entrySet())
            if (entry.getValue() == 1 && !map1.containsKey(entry.getKey()))
                list.add(entry.getKey());
        return list.toArray(new String[list.size()]);
    }


    public static void main(String[] args) {
//        "".startsWith()
    }
}
