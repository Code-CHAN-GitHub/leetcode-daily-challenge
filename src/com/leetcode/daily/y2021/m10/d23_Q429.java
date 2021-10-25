package com.leetcode.daily.y2021.m10;


class d23_Q429 {
    
    public int[] constructRectangle(int area) {
        for (int i = (int) Math.sqrt(area); ; i--) {
            if (area % i == 0) return new int[] {area / i, i};
        }
    }


    public static void main(String[] args) {
        int area = 122122;
        int[] res = new d23_Q429().constructRectangle(area);
        System.out.printf("[%d, %d]\n", res[0], res[1]);
    }
}