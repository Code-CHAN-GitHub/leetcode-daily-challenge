package com.leetcode.collect.存在重复元素III;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

import com.leetcode.utils.myassert.AssertUtils;

public class Collect_Q220 {
    
    /**
     * 时间复杂度：O(n * logk)
     * 空间复杂度：O(k)
     */
    // public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    //     TreeSet<Long> set = new TreeSet<>();
    //     int left = 0, right = 0;
    //     while (right < nums.length) {
    //         long num = nums[right++];
    //         Long ceiling = set.ceiling(num);
    //         Long floor = set.floor(num);
    //         if ((ceiling != null && ceiling - num <= t) || 
    //             (floor != null && num - floor <= t)) 
    //             return true;
    //         set.add(num);
    //         if (right - left > k)
    //             set.remove((long) nums[left++]);
    //     }
    //     return false;
    // }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Map<Long, Long> map = new HashMap<>();
        // [x - t, x + t] -> ... [-t - 1, -1] [0, t] [t + 1, t + 1 + t] ...
        // x = (t + 1) * a + b -> a = x / (t + 1)
        int left = 0, right = 0;
        while (right < nums.length) {
            long x = nums[right++];
            long id = getID(x, t);
            if (map.containsKey(id)) 
                return true;
            if (map.containsKey(id - 1) && x - map.get(id - 1) <= t)
                return true;
            if (map.containsKey(id + 1) && map.get(id + 1) - x <= t) 
                return true;
            map.put(id, x);
            if (right - left > k)
                map.remove(getID(nums[left++], t));
        }
        return false;
    }

    private Long getID(long x, long t) {
        if (x >= 0) {
            return x / (t + 1);
        }
        return x / (t + 1) - 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 9, 1, 5, 9};
        int k = 2, t = 3;
        boolean ret = new Collect_Q220().containsNearbyAlmostDuplicate(nums, k, t);
        AssertUtils.assertTrue(!ret);
    }

}