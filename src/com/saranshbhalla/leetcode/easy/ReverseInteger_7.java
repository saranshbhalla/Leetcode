package com.saranshbhalla.leetcode.easy;

public class ReverseInteger_7 {
    public static void main(String[] args) {
        System.out.println(reverse(123));
    }

    public static int reverse(int x) {
        int reverse = 0;
        /**
         * solve the inequality equation: reverse * 10 + x % 10 < Max; x>0
         * and reverse * 10 + x % 10 < Min; x<0
         */
        while(x!=0){
            if((x>0 && reverse*1.0 > (Integer.MAX_VALUE-x%10)/10.0) || (x<0 && reverse*1.0 < (Integer.MIN_VALUE-x%10)/10.0) )
                return 0;
            reverse = reverse * 10 + x % 10;
            x=x/10;
        }
        return reverse;
    }
}
