package com.leetcode.daily.y2021.m12;

public class d09_Q794 {

    char[][] map = new char[3][];
    int[][] node = new int[9][2];
    int[][] mark = new int[3][3];

    public boolean validTicTacToe(String[] board) {
        int countX = 0, countO = 0;
        for (int i = 0; i < 3; i++) {
            map[i] = board[i].toCharArray();
            for (int j = 0; j < 3; j++) {
                if (map[i][j] == 'X') {
                    node[countO + countX][0] = i;
                    node[countO + countX][1] = j;
                    countX++;
                } else if (map[i][j] == 'O') {
                    node[countO + countX][0] = i;
                    node[countO + countX][1] = j;
                    countO++;
                }
            }
        }
        if (countX < countO)
            return false;
        return dfs(true, 0, countX + countO);
    }

    private boolean dfs(boolean isX, int count, int sum) {
        if (count == sum) return true;
        for (int k = 0; k < sum; k++) {
            int i = node[k][0];
            int j = node[k][1];
            if (mark[i][j] == 0 && isX && map[i][j] == 'X') {
                mark[i][j] = 1;
                if (isWin(i, j)) {
                    if (count + 1 == sum) return true;
                } else if (dfs(!isX, count + 1, sum)) 
                    return true;
                mark[i][j] = 0;
            } else if (mark[i][j] == 0 && !isX && map[i][j] == 'O'){
                mark[i][j] = -1;
                if (isWin(i, j)) {
                    if (count + 1 == sum) return true;
                } else if (dfs(!isX, count + 1, sum)) 
                    return true;
                mark[i][j] = 0;
            }
        }
        return false;
    }

    private boolean isWin(int x, int y) {
        int sum = mark[0][y] + mark[1][y] + mark[2][y];
        if (sum == 3 || sum == -3) 
            return true;
        sum = mark[x][0] + mark[x][1] + mark[x][2];
        if (sum == 3 || sum == -3) 
            return true;
        if (x == y) {
            sum = mark[0][0] + mark[1][1] + mark[2][2];
            if (sum == 3 || sum == -3) return true;
        }
        if (x + y == 2) {
            sum = mark[0][2] + mark[1][1] + mark[2][0];
            if (sum == 3 || sum == -3) return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        String[] board = {"XXX","OOX","OOX"};
        boolean res = new d09_Q794().validTicTacToe(board);
        System.out.println(res);
    }
}