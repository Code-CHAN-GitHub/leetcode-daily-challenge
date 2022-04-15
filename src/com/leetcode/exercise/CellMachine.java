package com.leetcode.exercise;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * @author chen
 * @create 2022-02-13-11:40
 */
public class CellMachine {

    int[][] board;

    static int[][] DELTA = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    private void gameOfLife() {
        // 0: dead  1: live  2: deadToLive  3: liveToDead
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cnt = 0;
                for (int[] d : DELTA) {
                    int x = i + d[0], y = j + d[1];
                    if (x >= 0 && x < m && y >= 0 && y < n &&
                            (board[x][y] == 1 || board[x][y] == 3)) {
                        cnt++;
                    }
                }
                if (board[i][j] == 1 && (cnt < 2 || cnt > 3))
                    board[i][j] = 3;
                else if (board[i][j] == 0 && cnt == 3)
                    board[i][j] = 2;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2)
                    board[i][j] = 1;
                else if (board[i][j] == 3)
                    board[i][j] = 0;
            }
        }
    }

    private void printBoard() {
        for (int[] line : board) {
            System.out.println(Arrays.toString(line));
        }
        System.out.println("\n");
    }

    public CellMachine init(int m, int n, int cellNum) {
        board = new int[m][n];
        while (cellNum > 0) {
            int random = (int) (Math.random() * (m * n));
            int x = random / n, y = random % n;
            if (board[x][y] == 0) {
                board[x][y] = 1;
                cellNum--;
            }
        }
        return this;
    }

    public void start() {
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            printBoard();
            gameOfLife();
        }
    }

    public static void main(String[] args) {
        new CellMachine().init(5, 5, 12).start();
    }
}
