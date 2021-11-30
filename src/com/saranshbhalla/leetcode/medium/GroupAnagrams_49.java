package com.saranshbhalla.leetcode.medium;

import java.util.*;

public class GroupAnagrams_49 {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(strs);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> sortedKeysMap = new HashMap<>();
        for (String str : strs) {
            char[] strArr = str.toCharArray();
            Arrays.sort(strArr);
            String sortedStr = String.valueOf(strArr);

            if (!sortedKeysMap.containsKey(sortedStr))
                sortedKeysMap.put(sortedStr, new ArrayList<>());
            sortedKeysMap.get(sortedStr).add(str);
        }
        return new ArrayList<>(sortedKeysMap.values());
    }

    public static List<List<String>> implementation2(String[] strs) {
        Map<String, List<String>> sortedKeysMap = new HashMap<>();
        for (String str : strs) {
            String key = StringSignature.getSignature(str);
            if (!sortedKeysMap.containsKey(key))
                sortedKeysMap.put(key, new ArrayList<>());
            sortedKeysMap.get(key).add(str);
        }
        return new ArrayList<>(sortedKeysMap.values());
    }

    static class StringSignature {
        public static String getSignature(String str) {
            char[] chArr = new char[26];
            for (int i = 0; i < 26; i++) {
                chArr[i] = '0';
            }
            for(char ch : str.toCharArray()){
                chArr[ch-97]++;
            }
            return String.valueOf(chArr);
        }
    }
}
