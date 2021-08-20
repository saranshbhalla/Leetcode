package com.saranshbhalla.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MeetingRooms2_253 {
    /**
     * DO IT AGAIN
     */
    public static void main(String[] args) {
        System.out.println(minMeetingRooms(new int[][] {{0,1},{0,3}}));
    }

    public static int minMeetingRooms2(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        List<int[]> result = new ArrayList<>();
        for(int i=0; i < intervals.length; i++){
            boolean added = false;
            for(int j = 0;j<result.size(); j++){
                int[] interval = result.get(j);
                if(interval[1]<=intervals[i][0]) {
                    result.set(j, new int[]{interval[0], intervals[i][1]});
                    added = true;
                    break;
                }
            }
            if(!added)
                result.add(new int[]{intervals[i][0], intervals[i][1]});
        }
        return result.size();
    }

    public static int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        PriorityQueue<Integer> result = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });

        for(int i=0; i < intervals.length; i++){
            if(!result.isEmpty() && result.peek()<=intervals[i][0]) {
                result.poll();
            }
            result.add(intervals[i][1]);
        }
        return result.size();
    }
}
