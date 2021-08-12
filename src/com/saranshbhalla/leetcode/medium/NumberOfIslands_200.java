package com.saranshbhalla.leetcode.medium;

public class NumberOfIslands_200 {
    public static void main(String[] args) {
        System.out.println(numIslands(new char[][] {{'1','1','1'},{'0','1','0'},{'1','1','1'}}));
    }

    public static int numIslands(char[][] grid) {
        int islands = 0;
        for(int i=0;i< grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j]=='1'){
                    dfs(grid, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }

    private static void dfs (char[][] grid, int row, int col){
        grid[row][col] = '2';
        if(row<grid.length-1 && grid[row+1][col]=='1')
            dfs(grid, row+1, col);
        if(col<grid[row].length-1&&grid[row][col+1]=='1')
            dfs(grid, row, col+1);

        if(row>0 && grid[row-1][col]=='1')
            dfs(grid, row-1, col);
        if(col>0&&grid[row][col-1]=='1')
            dfs(grid, row, col-1);
    }

}
