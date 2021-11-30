package com.saranshbhalla.leetcode.medium;

import java.util.Arrays;

public class NextPermutation_31 {
    public static void main(String[] args) {
        int[] nums = {2,3,1};
        nextPermutation(nums);
    }

    public static void nextPermutation(int[] nums) {
        //find the pivot
        int pivotIndex = -1;
        for (int i = nums.length-2 ; i >= 0; i--) {
            if(nums[i]<nums[i+1]) {
                pivotIndex = i;
                break;
            }
        }

        // if pivot not found, sort and return
        if(pivotIndex==-1){
            Arrays.sort(nums);
            System.out.println(Arrays.toString(nums));
            return;
        }

        //replace pivot with the next biggest number
        int minDifference = Integer.MAX_VALUE;
        int replacementIndex = -1;
        for(int i = pivotIndex+1 ; i<nums.length; i++){
            int diff = nums[i] - nums[pivotIndex];
            if(nums[i]>nums[pivotIndex] && diff<minDifference){
                minDifference = diff;
                replacementIndex = i;
            }
        }
        int temp = nums[replacementIndex];
        nums[replacementIndex] = nums[pivotIndex];
        nums[pivotIndex] = temp;

        //sort the elements after pivot
        Arrays.sort(nums, pivotIndex+1, nums.length);
        System.out.println(Arrays.toString(nums));

    }
}
