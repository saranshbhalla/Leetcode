package com.saranshbhalla.leetcode.medium;

public class UniquePaths_62 {
    public static void main(String[] args) {

    }

    public int uniquePaths(int m, int n) {
        return bfsa(m-1, n-1, 0, 0, new Integer[m][n]);
    }

    int bfsa(int m, int n, int i, int j, Integer[][] indexed){
        if(i>m || j>n)
            return 0;
        if(indexed[i][j]!=null)
            return indexed[i][j];
        if(i==m && j==n)
            return 1;
        int result=  (bfsa(m,n,i+1,j, indexed) + bfsa(m, n,i,j+1, indexed));
        indexed[i][j] = result;
        return result;
    }
}
