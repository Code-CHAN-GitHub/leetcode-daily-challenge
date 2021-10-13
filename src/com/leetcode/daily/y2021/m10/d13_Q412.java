package com.leetcode.daily.y2021.m10;

import java.util.List;
import java.util.ArrayList;

class d13_Q412 {

    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0)
                ans.add("FizzBuzz");
            else if (i % 3 == 0)
                ans.add("Fizz");
            else if (i % 5 == 0)
                ans.add("Buzz");
            else 
                ans.add(String.valueOf(i));
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 10;
        List<String> res = new d13_Q412().fizzBuzz(n);
        res.forEach(System.out::println);
    }

}