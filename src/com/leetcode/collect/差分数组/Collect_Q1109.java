package com.leetcode.collect.差分数组;

class Collect_Q405 {
    
    /**
     * 考察：差分数组
     *      对一段连续的区域 nums[i,..,j] 进行操作，可以利用差分数组
     *      只需修改 d[i]、d[j + 1] 即可
     *      又 nums[i] - nums[i - 1] = d[i]
     *      可由数组 d 反推回 nums, 即 nums[i] = d[i] + nums[i - 1]
     * 
     * 改进：
     *      相较于初次提交，从 3ms -> 2ms
     *      较初次提交，删除了数组 a，这是因为数组 a 只是一个空数组
     *      而我们可以利用 dp 数组累加自身，效果与原来相同
     *      减少了空间的占用
     */
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] dp = new int[n];
        for (int[] book : bookings) {
            int first = book[0] - 1, last = book[1] - 1, seat = book[2];
            dp[first] += seat;
            if (last != n - 1)
                dp[last + 1] -= seat;
        }
        for (int i = 1; i < n; i++)
            dp[i] += dp[i - 1];
        return dp;
    }

    /*
        初次提交
    */
    // public int[] corpFlightBookings(int[][] bookings, int n) {
    //     int[] d = new int[n + 1];
    //     for (int[] book : bookings) {
    //         d[book[0]] += book[2];
    //         if (book[1] != n) {
    //             d[book[1] + 1] -= book[2];
    //         }
    //     }
    //     int[] res = new int[n];
    //     res[0] = d[1];
    //     for (int i = 1; i < n; i++) {
    //         res[i] = res[i - 1] + d[i + 1];
    //     }
    //     return res;
    // }


    public static void main(String[] args) {
        
    }

}