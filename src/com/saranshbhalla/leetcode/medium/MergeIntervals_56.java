package com.saranshbhalla.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals_56 {

    public static void main(String[] args) {
        int[][] result = merge(new int[][]{
                {1,3},
                {2,6},
                {5,6},
                {4,4},
                {8,10}
                });
        for(int[] res : result){
            System.out.println(res[0]+","+res[1]);
        }
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        List<int[]> result = new ArrayList<>();
        int[] mostRecent = intervals[0];
        for(int i = 1; i<intervals.length; i++){
            if(intervals[i][0]<=mostRecent[1]) {
                if (intervals[i][1] > mostRecent[1])
                    mostRecent[1] = intervals[i][1];
            }
            else{
                result.add(mostRecent);
                mostRecent = intervals[i];
            }
        }
        result.add(mostRecent);

        int[][] resultArr = new int[result.size()][2];
        for(int i=0;i<resultArr.length; i++)
            resultArr[i]=result.get(i);
        return resultArr;
    }
}
