package com.saranshbhalla.leetcode.medium;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses_1249 {

    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("ab)(cd"));

    }

    public static String minRemoveToMakeValid(String s) {
        Stack<Integer> openedParenthesis = new Stack<>();
        char[] chars = s.toCharArray();
        Set<Integer> toBeRemoved = new HashSet<>();

        for(int i=0; i<chars.length; i++){
            char ch = chars[i];
            if(ch=='(')
                openedParenthesis.push(i);
            else if (ch ==')')
                if(!openedParenthesis.isEmpty())
                    openedParenthesis.pop();
                else
                    toBeRemoved.add(i);
        }
        if(!openedParenthesis.isEmpty())
            toBeRemoved.addAll(openedParenthesis);

        StringBuffer result = new StringBuffer();
        for(int i=0; i<chars.length; i++){
            if(!toBeRemoved.contains(i))
                result.append(chars[i]);
        }
        return result.toString();
    }
}
