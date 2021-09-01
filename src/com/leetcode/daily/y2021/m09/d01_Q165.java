package com.leetcode.daily.y2021.m09;

public class d01_Q165 {
  

  public int compareVersion(String version1, String version2) {
    String[] strs1 = version1.split("\\.");
    String[] strs2 = version2.split("\\.");
    
    int i = 0;
    while (i < strs1.length || i < strs2.length) {
      int x = i >= strs1.length ? 0 : strToInt(strs1[i]);
      int y = i >= strs2.length ? 0 : strToInt(strs2[i]);
      if (x != y) {
        return x < y ? -1 : 1;
      }
      i++;
    }
    
    return 0;
  }

  private int strToInt(String str) {
    char[] chars = str.toCharArray();
    int num = 0, i = 0;
    while (i < chars.length && chars[i] == '0') {
      i++;
    }
    while (i < chars.length) {
      num = num * 10 + (chars[i++] - '0');
    }
    return num;
  }

  public static void main(String[] args) {
    String version1 = "0.1";
    String version2 = "1.1";
    int res = new d01_Q165().compareVersion(version1, version2);
    System.out.println(res);
  }

}