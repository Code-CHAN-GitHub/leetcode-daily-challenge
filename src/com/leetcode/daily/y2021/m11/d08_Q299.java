package com.leetcode.daily.y2021.m11;

import sun.launcher.resources.launcher;

class d08_Q299 {

    public String getHint(String secret, String guess) {
        int[] cnt1 = new int[10];
        int[] cnt2 = new int[10];
        int a = 0, b = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                a++;
            } else {
                cnt1[secret.charAt(i) - '0']++;
                cnt2[guess.charAt(i) - '0']++;
            }
        }
        for (int i = 0; i < 10; i++) 
            b += Math.min(cnt1[i], cnt2[i]);
        return a + "A" + b + "B";
    }

    public static void main(String[] args) {
        String secret = "1807";
        String guess = "7810";
        String res = new d08_Q299().getHint(secret, guess);
        System.out.println(res);
    }

}