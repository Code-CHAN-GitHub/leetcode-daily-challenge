package com.leetcode.utils.myassert;

public class AssertUtils {

    public static void assertTrue(boolean b) {
        if (!b) {
            throw new AssertionError();
        }
    }
    
}