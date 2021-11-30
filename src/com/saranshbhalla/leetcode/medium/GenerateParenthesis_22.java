package com.saranshbhalla.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis_22 {
    public static void main(String[] args) {

    }

    public static List<String> generateParenthesis(int n) {
        List<String> solution = new ArrayList<>();
        generate("", 0, 0, n, solution);
        return solution;
    }

    public static void generate(String str, int opened, int closed, int total, List<String> combinations) {
        if (opened == closed && opened == total)
            combinations.add(str);
        if (opened < total)
            generate(str + "(", opened + 1, closed, total, combinations);
        if (closed < opened)
            generate(str + ")", opened, closed + 1, total, combinations);
    }
}
