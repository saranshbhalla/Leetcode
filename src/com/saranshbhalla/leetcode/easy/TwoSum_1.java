package com.saranshbhalla.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum_1 {

    public static void main(String[] args) {
        int[] result = twoSum(new int[]{0,2,-1,1}, 0);
        System.out.println(result[0]+","+result[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int remainder = target-nums[i];
            if(map.containsKey(remainder))
                return new int[]{map.get(remainder), i};
            map.put(nums[i], i);
        }
        return null;
    }
}
