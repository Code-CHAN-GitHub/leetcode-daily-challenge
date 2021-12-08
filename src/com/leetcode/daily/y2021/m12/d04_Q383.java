package com.leetcode.daily.y2021.m12;

public class d04_Q383 {

    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        int[] count = new int[128];
        for (int i = 0; i < magazine.length(); i++) {
            count[magazine.charAt(i)]++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (--count[ransomNote.charAt(i)] < 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aab";
        boolean res = new d04_Q383().canConstruct(ransomNote, magazine);
        System.out.println(res);
    }
    
}