package com.leetcode.daily.y2021.m10;

class d25_Q240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = m - 1, j = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] == target)
                return true;
            else if (matrix[i][j] > target) 
                i--;
            else
                j++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target = 5;
        boolean res = new d25_Q240().searchMatrix(matrix, target);
        System.out.println(res);
    }

}