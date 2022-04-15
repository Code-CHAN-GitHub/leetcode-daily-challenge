package com.leetcode.daily.y2021.m12;

public class d18_Q419 {

    public int countBattleships(char[][] board) {
        int m = board.length, n = board[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                 if (board[i][j] == 'X') {
                     if (!((i != 0 && board[i - 1][j] == 'X') ||
                         (j != 0 && board[i][j - 1] == 'X'))) {
                         ans++;
                     }
                 }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        char[][] board = {
            {'X', '.', '.', 'X'},
            {'.', '.', '.', 'X'},
            {'.', '.', '.', 'X'},
            {'.', '.', '.', '.'}
        };
        int res = new d18_Q419().countBattleships(board);
        System.out.println(res);
    }
    
}