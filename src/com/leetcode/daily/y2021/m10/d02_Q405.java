package com.leetcode.daily.y2021.m10;

class d02_Q405 {
    
    public String toHex(int num) {
        if (num == 0) return "0";
        char[] s = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(s[num & 0xf]);
            num = num >>> 4;
        }
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        int num = 26;
        String res = new d02_Q405().toHex(26);
        System.out.println(res);
    }

}