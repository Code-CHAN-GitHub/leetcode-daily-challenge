package com.leetcode.daily.y2022.m01;

import com.leetcode.utils.myassert.AssertUtils;

import java.util.Arrays;

/**
 * @author chen
 * @create 2022-01-28-18:45
 */
public class d28_Q1996 {

    public int numberOfWeakCharacters(int[][] props) {
        Arrays.sort(props, (a, b) -> a[0] == b[0] ? b[1] - a[1] : b[0] - a[0]);
        int n = props.length, ans = 0;
        for (int i = 0, max = props[0][1]; i < n; ) {
            int j = i;
            while (j < n && props[j][0] == props[i][0]) {
                if (i != 0 && props[j][1] < max)
                    ans++;
                j++;
            }
            max = Math.max(max, props[i][1]);
            i = j;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] props = {{1, 1}, {2, 1}, {2, 2}, {1, 2}};
        int ret = new d28_Q1996().numberOfWeakCharacters(props);
        AssertUtils.assertTrue(ret == 1);
    }
}
