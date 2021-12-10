package com.saranshbhalla.leetcode.medium;

public class WordSearch_79 {
    public static void main(String[] args) {
        char[][] charArr = {{'A'}};
        System.out.println(exist(charArr, "A"));
    }

    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boolean foundInBfs = bfs(board, word, 0, i, j);
                if (foundInBfs)
                    return true;
            }
        }
        return false;
    }


    public static boolean bfs(char[][] board, String word, int index, int row, int col) {
        char ch = board[row][col];
        if (word.length() - 1 == index && ch == word.charAt(index))
            return true;
        if (ch != word.charAt(index))
            return false;

        board[row][col] = '1';
        //left
        if (col > 0 && board[row][col - 1] != 1) {
            if (bfs(board, word, index + 1, row, col - 1))
                return true;
        }

        //right
        if (col < board[0].length - 1 && board[row][col + 1] != 1) {
            if (bfs(board, word, index + 1, row, col + 1))
                return true;
        }

        //top
        if (row > 0 && board[row - 1][col] != 1) {
            if (bfs(board, word, index + 1, row - 1, col))
                return true;
        }

        //bottom
        if (row < board.length - 1 && board[row + 1][col] != 1) {
            if (bfs(board, word, index + 1, row + 1, col))
                return true;
        }
        board[row][col] = ch;
        return false;
    }

}
