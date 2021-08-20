package com.saranshbhalla.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK_560 {
    /**
     * DO IT AGAIN
     */
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,2,3}, 3));
    }

    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> sums = new HashMap<>();
        sums.put(0, 1);
        int totalSum = 0;
        int result = 0;
        for(int i=0;i<nums.length;i++){
            totalSum = totalSum + nums[i];

            int balance = totalSum - k;
            if(sums.containsKey(balance))
                result  += sums.get(balance);
            sums.put(totalSum, sums.getOrDefault(totalSum, 0)+1);
        }
        return result;
    }
}
