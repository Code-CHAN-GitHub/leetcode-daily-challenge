package com.leetcode.daily.y2021.m12;

public class d11_Q911 {
 
    class TopVotedCandidate {

        int[][] lead;
    
        public TopVotedCandidate(int[] persons, int[] times) {
            int n = persons.length;
            lead = new int[n][2];
            int[] counts = new int[n];
            int max = 0, maxp = -1;
            for (int i = 0; i < n; i++) {
                if (++counts[persons[i]] >= max) {
                    maxp = persons[i];
                    max = counts[maxp];
                }
                lead[i][0] = times[i];
                lead[i][1] = maxp;
            }
        }
        
        public int q(int t) {
            int left = 0, right = lead.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (lead[mid][0] > t) 
                    right = t;
                else 
                    left = t + 1;
            }
            return lead[left - 1][1];
        }
    }

    public static void main(String[] args) {
        int[] persons = {0, 1, 1, 0, 0, 1, 0};
        int[] times = {0, 5, 10, 15, 20, 25, 30};
        TopVotedCandidate tv = new d11_Q911().new TopVotedCandidate(persons, times);
        
    }

}