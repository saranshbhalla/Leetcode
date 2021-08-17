package com.saranshbhalla.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis_20 {
    public static void main(String[] args) {
        System.out.println(isValid("{{[()}}}"));
    }

    public static boolean isValid(String s) {
        char[] str = s.toCharArray();

        Map<Character, Character> braces = new HashMap<>();
        braces.put(')', '(');
        braces.put('}', '{');
        braces.put(']', '[');

        Stack<Character> stack = new Stack<>();
        for(int i=0;i< str.length;i++){
            char ch = str[i];
            if(ch == '(' || ch=='[' || ch=='{')
                stack.push(ch);
            else{
                if(stack.isEmpty())
                    return false;
                char latest = stack.pop();
                if(latest!=braces.get(ch))
                    return false;
            }
        }
        return stack.isEmpty();
    }

}
