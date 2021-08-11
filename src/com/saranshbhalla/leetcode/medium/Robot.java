package com.saranshbhalla.leetcode.medium;

public class Robot {
    public static void main(String[] args) {
        //values R, L and G
    }

    public boolean isRobotBounded(String instructions) {
        int[][] moves = {{0,1},{1,0},{0,-1},{-1,0}};
        int[] position = {0,0};
        int direction = 0;

        for(int i=0 ;i<4; i++) {
            for (char ch : instructions.toCharArray()) {
                if (ch == 'G') {
                    position[0] += moves[direction][0];
                    position[1] += moves[direction][1];
                } else if (ch == 'R')
                    direction = (direction+1)%4;
                if (ch == 'L')
                    direction = (direction+3)%4;
            }
            if ((position[0] == 0 && position[1] == 0) && direction == 0)
                return true;
        }
        return false;
    }
}
