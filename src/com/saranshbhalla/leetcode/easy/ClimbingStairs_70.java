package com.saranshbhalla.leetcode.easy;

public class ClimbingStairs_70 {
    public static void main(String[] args) {

    }

    public int climbStairs(int n) {
        if(n==1 || n==2)
            return n;

        int a = 1;
        int b = 2;
        for(int i=2; i<n ;i++){
            int c = a+b;
            a = b;
            b = c;
        }
        return b;
    }
}
