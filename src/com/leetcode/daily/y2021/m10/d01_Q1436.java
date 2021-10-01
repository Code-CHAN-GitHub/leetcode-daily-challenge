package com.leetcode.daily.y2021.m10;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class d01_Q1436 {
    
    public String destCity(List<List<String>> paths) {
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < paths.size(); i++) {
            List<String> path = paths.get(i);
            map.put(path.get(0), i);
        }
        String next = paths.get(0).get(1);
        Integer i = map.get(next);
        while (i != null) {
            next = paths.get(i).get(1);
            i = map.get(next);
        }
        return next;
    }

    public static void main(String[] args) {
        List<List<String>> paths = new ArrayList<>();
        paths.add(Arrays.asList("London","New York"));
        paths.add(Arrays.asList("New York","Lima"));
        paths.add(Arrays.asList("Lima","Sao Paulo"));
        String res = new d01_Q1436().destCity(paths);
        System.out.println(res);
    }

}