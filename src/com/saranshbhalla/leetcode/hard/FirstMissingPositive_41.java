package com.saranshbhalla.leetcode.hard;

public class FirstMissingPositive_41 {

    public static void main(String[] args) {
        int[] nums = {1,2,0};
        System.out.println(firstMissingPositive(nums));
    }

    public static int firstMissingPositive(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] == 1)
                count++;

        if (count == 0)
            return 1;

        for (int i = 0; i < nums.length; i++)
            if (nums[i] <= 0 || nums[i]>=nums.length)
                nums[i] = 1;

        for(int i=0;i<nums.length;i++){
            int index = Math.abs(nums[i]);
            if (index == nums.length)
                nums[0] = - Math.abs(nums[0]);
            else
                nums[index] = -1 * Math.abs(nums[index]);
        }

        for(int i=2;i<nums.length;i++){
            if(nums[i]>0)
                return i;
        }
        if(nums[0]<0)
            return nums.length + 1;
        return nums.length;
    }

}
