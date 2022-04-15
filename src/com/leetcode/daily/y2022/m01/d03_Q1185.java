package com.leetcode.daily.y2022.m01;

import com.leetcode.utils.myassert.AssertUtils;

public class d03_Q1185 {

    int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    String[] words = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    public String dayOfTheWeek(int day, int month, int year) {
        int cnt = 0;
        for (int y = 1971; y < year; y++) {
            cnt += 365;
            if (isRun(y)) cnt++;
        }
        for (int m = 1; m < month; m++) {
            cnt += days[m];
            if (m == 2 && isRun(year)) cnt++;
        }
        cnt += day;
        cnt %= 7;
        int ans = (cnt + 4) % 7; // 1971 年 1 月 1 日 为周五
        return words[ans];
    }

    private boolean isRun(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }

    public static void main(String[] args) {
        int day = 3, month = 1, year = 2022;
        String ret = new d03_Q1185().dayOfTheWeek(day, month, year);
        AssertUtils.assertTrue(ret.equals("Monday"));
    }
}