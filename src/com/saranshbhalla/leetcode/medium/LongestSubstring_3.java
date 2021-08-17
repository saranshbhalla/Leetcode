package com.saranshbhalla.leetcode.medium;

public class LongestSubstring_3 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        char[] str = s.toCharArray();
        Integer[] charIndex = new Integer[256];

        if (s==null || s.isEmpty())
            return maxLength;

        int startInd = 0;
        for(int endIndex = 0; endIndex<str.length; endIndex++){
            char c = str[endIndex];
            if(charIndex[c]!=null) {
                maxLength = Math.max(maxLength, endIndex - startInd);
                int newStart = charIndex[c] + 1;
                resetArray(charIndex, startInd, charIndex[c], str);
                startInd = newStart;
            }
            charIndex[c] = endIndex;
        }
        maxLength = Math.max(maxLength, str.length - startInd);
        return maxLength;
    }

    private static void resetArray(Integer[] charIndex, int fromIndex, int toIndex, char[] str){
        for(int i=fromIndex;i<=toIndex; i++)
            charIndex[str[i]]=null;
    }
}
