package com.saranshbhalla.leetcode.easy;

public class LongestCommonPrefex_14 {
    public static void main(String[] args) {

    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        return findLongestCommonPrefix(strs);
    }

    private static String findLongestCommonPrefix(String[] strs) {
        String initialPrefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            initialPrefix = findIntersection(strs[i], initialPrefix);
        return initialPrefix;
    }

    private static String findIntersection(String str, String prefix) {
        char[] strCh = str.toCharArray();
        char[] prefixCh = prefix.toCharArray();
        int smallerLength = Math.min(str.length(), prefix.length());
        for (int i = 0; i < smallerLength; i++) {
            if (strCh[i] != prefixCh[i])
                return prefix.substring(0, i);
        }
        return prefix.substring(0,smallerLength);
    }
}
