package com.saranshbhalla.leetcode.medium;

public class LongestPalindromicSubstring_5 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccbe"));
    }

    public static String longestPalindrome(String s) {
        char[] str = s.toCharArray();
        int count = 0;
        int startIndex = -1;
        int endIndex = -1;
        for(int i=0; i< str.length; i++){
            int countA = findPalindrome(str, i-1, i+1);
            if(count < 1 + 2*countA){
                count = 1 + 2*countA;
                startIndex = i-countA;
                endIndex = i+countA;
            }

            int countB = findPalindrome(str, i, i+1);
            if(count < 2*countB){
                count = 2*countB;
                startIndex = i - countB + 1;
                endIndex = i + countB;
            }
        }
        return s.substring(startIndex, endIndex+1);
    }

    private static int findPalindrome (char[] chars,  int startIndex, int endIndex){
        if(startIndex<0 || endIndex>chars.length-1)
            return 0;

        if(chars[startIndex]==chars[endIndex]){
            startIndex--;
            endIndex++;
            return 1 + findPalindrome(chars, startIndex, endIndex);
        }
        return 0;
    }
}
