package com.leetcode.daily.y2021.m10;

class d28_Q869 {

    public boolean reorderedPowerOf2(int n) {
        int[] book = new int[10];
        int len = 0;
        while (n > 0) {
            book[n % 10]++;
            n /= 10;
            len++;
        }
        for (int i = 0; i < 31; i++) {
            String s = String.valueOf(1 << i);
            if (s.length() == len) {
                int[] clone = book.clone();
                boolean flag = true;
                for (int j = 0; j < len; j++) {
                    if (--clone[s.charAt(j) - '0'] < 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 1;
        boolean res = new d28_Q869().reorderedPowerOf2(n);
        System.out.println(res);
    }

}