package com.leetcode.daily.y2021.m09;

public class d17_Q36 {

    public boolean isValidSudoku(char[][] board) {
        int[] row = new int[9];
        int[] col = new int[9];
        int[] x9 = new int[9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int n = 1 << (c - '0');
                    if ((row[i] & n) != 0 || (col[j] & n) != 0 || (x9[(i / 3) * 3 + j / 3] & n) != 0)
                        return false;
                    row[i] |= n;
                    col[j] |= n;
                    x9[(i / 3) * 3 + j / 3] |= n;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'}
            ,{'6','.','.','1','9','5','.','.','.'}
            ,{'.','9','8','.','.','.','.','6','.'}
            ,{'8','.','.','.','6','.','.','.','3'}
            ,{'4','.','.','8','.','3','.','.','1'}
            ,{'7','.','.','.','2','.','.','.','6'}
            ,{'.','6','.','.','.','.','2','8','.'}
            ,{'.','.','.','4','1','9','.','.','5'}
            ,{'.','.','.','.','8','.','.','7','9'}
        };
        boolean res = new d17_Q36().isValidSudoku(board);
        System.out.println(res);
    }
    
}