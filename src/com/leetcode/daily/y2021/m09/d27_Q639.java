package com.leetcode.daily.y2021.m09;

class d27_Q639 {

    public int numDecodings(String s) {
        if (s.charAt(0) == '0')
            return 0;
        
        int n = s.length();
        long[] dp = new long[n + 1];
        int mod = (int) (1e9 + 7);
        dp[0] = 1;
        dp[1] = s.charAt(0) == '*' ? 9 : 1;
        
        for (int i = 2; i <= n; i++) {
            char cur = s.charAt(i - 1);
            char pre = s.charAt(i - 2);
            if (cur == '0') {
                if (pre == '1' || pre == '2')
                    dp[i] = dp[i - 2];
                else if (pre == '*')
                    dp[i] = (dp[i - 2] * 2) % mod;
                else 
                    return 0;
            } else {
                if (cur == '*') {
                    dp[i] = (dp[i - 1] * 9) % mod;
                    switch (pre) {
                        case '1': dp[i] = (dp[i] + dp[i - 2] * 9) % mod; break;
                        case '2': dp[i] = (dp[i] + dp[i - 2] * 6) % mod; break;
                        case '*': dp[i] = (dp[i] + dp[i - 2] * 15) % mod; break;
                    }
                } else {
                    dp[i] = dp[i - 1];
                    if (pre == '1')
                        dp[i] = (dp[i] + dp[i - 2]) % mod;
                    else if (pre == '2' && cur <= '6')
                        dp[i] = (dp[i] + dp[i - 2]) % mod;
                    else if (pre == '*')
                        dp[i] = (dp[i] + (cur <= '6' ? dp[i - 2] * 2 : dp[i - 2])) % mod; 
                }
            }
        }
        
        return (int)dp[n];
    }

    public static void main(String[] args) {
        String s = "11106";
        int res = new d27_Q639().numDecodings(s);
        System.out.println(res);
    }

}