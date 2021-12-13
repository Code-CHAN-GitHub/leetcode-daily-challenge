package com.leetcode.daily.y2021.m12;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class d10_Q748 {

    static List<Integer> primes = new ArrayList<>();

    static {
        boolean[] isPrime = new boolean[1000];
        Arrays.fill(isPrime, true);
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                primes.add(i);
                if (primes.size() == 26) {
                    break;
                }
                for (int j = 2; j * i < isPrime.length; j++) {
                    isPrime[j * i] = false;
                }
            }
        }
    }

    public String shortestCompletingWord(String licensePlate, String[] words) {
        long key = 1;
        for (int i = 0; i < licensePlate.length(); i++) {
            char c = licensePlate.charAt(i);
            if (Character.isAlphabetic(c)) {
                c = Character.toLowerCase(c);
                key *= primes.get(c - 'a');
            }
        }
        String ans = null;
        int min = 20;
        for (String word : words) {
            long x = 1;
            for (int i = 0; i < word.length() && x % key != 0; i++) {
                x *= primes.get(word.charAt(i) - 'a');
            }
            if (x % key == 0 && (ans == null || word.length() < min)) {
                ans = word;
                min = word.length();
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String licensePlate = "NsTGrO4";
        String[] words = {"strong", "great","resource","building","talk","always","theory","teach","from","finally"};
        String res = new d10_Q748().shortestCompletingWord(licensePlate, words);
        System.out.println(res);
    }
}