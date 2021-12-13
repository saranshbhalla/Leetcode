package com.saranshbhalla.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval_57 {
    public static void main(String[] args) {

    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length ==0)
            return new int[][]{newInterval};

        int newS = newInterval[0];
        int newE = newInterval[1];

        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (newInterval == null || newS > end) {
                result.add(intervals[i]);
            } else {
                if (newE < start) {
                    result.add(newInterval);
                    result.add(intervals[i]);
                } else {
                    while (newE > end && i < intervals.length - 1 && newE >= intervals[i + 1][0]) {
                        i++;
                        end = intervals[i][1];
                    }
                    result.add(new int[]{Math.min(start, newS), Math.max(end, newE)});
                }
                newInterval = null;
            }
        }
        if(newInterval!=null)
            result.add(newInterval);

        int[][] res = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++)
            res[i] = result.get(i);
        return res;
    }
/*
    start, mid, end

    [S, E]
    loop over the array, pass the element where start, end < S

    if S is less then start and E < start => new interval

    S>Start and E<end => remains same

    if S < start
        start = S
    == this could be while block ==
        if E> end
            if E < next start
                change end to E
            else
                loop



    */
}
