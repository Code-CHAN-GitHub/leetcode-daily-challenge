package com.leetcode.daily.y2021.m12;

public class d22_Q686 {

    public int repeatedStringMatch(String a, String b) {
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();
        int ans = -1;
        for (int i = 0; i < charsA.length; i++)
            if ((ans = check(i, charsA, charsB)) != -1)
                break;
        return ans;
    }

    private int check(int start, char[] charsA, char[] charsB) {
        int i = start, j = 0;
        while (j < charsB.length && i < charsA.length) {
            if (charsA[i++] != charsB[j++])
                return -1;
        }
        int k = 1;
        while (j < charsB.length) {
            for (i = 0; i < charsA.length && j < charsB.length; i++, j++) {
                if (charsA[i] != charsB[j])
                    return -1;
            }
            k++;
        }
        return k;
    }

    public static void main(String[] args) {
        String a = "abcd";
        String b = "cdabcdabcdabcdabcdabcdabcdabcdabcdab";
        int res = new d22_Q686().repeatedStringMatch(a, b);
        System.out.println(res);
    }
    
}