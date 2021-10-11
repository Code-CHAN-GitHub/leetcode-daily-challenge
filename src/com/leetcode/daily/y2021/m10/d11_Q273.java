package com.leetcode.daily.y2021.m10;

import java.util.ArrayList;
import java.util.List;

class d11_Q273 {
    
    String[] rule1 = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                        "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] rule2 = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    String[] rule3 = {"", " Thousand", " Million", " Billion"};
    
    public String numberToWords(int num) {
        if (num  < 1000)
            return helper2(num);

        StringBuilder sb = new StringBuilder();
        for (int i = (int)1e9, j = 3; i >= 1; i /= 1000, j--) {
            if (num / i > 0) {
                sb.append(helper2(num / i) + rule3[j]).append(" ");
            }
            num %= i;
        }

        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }

    // [0, 99]
    private String helper(int num) {
        if (num < rule1.length)
            return rule1[num];
        return rule2[num / 10] + (num % 10 == 0 ? "" : " " + rule1[num % 10]);
    }

    // [0, 999]
    private String helper2(int num) {
        String s = "";
        if (num >= 100) {
            s += rule1[num / 100] + " Hundred";
            num %= 100;
            if (num > 0) {
                s += " " + helper(num);
            }
        } else {
            s = helper(num);
        }
        return s;
    }

    public static void main(String[] args) {
        int num = 1234567891;
        String res = new d11_Q273().numberToWords(num);
        System.out.println(res);
    }
}