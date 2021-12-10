package com.saranshbhalla.leetcode.medium;

public class SearchInRotatedSortedArray_33 {
    public static void main(String[] args) {
        System.out.println(search(new int[]{1,3}, 2));
    }

    public static int search(int[] nums, int target) {
        int biggestIndex = findBiggestIndex(nums);
        if (target <= nums[biggestIndex] && target >= nums[0])
            return binarySearch(nums, target, 0, biggestIndex);
        else
            return binarySearch(nums, target, biggestIndex + 1, nums.length - 1);
    }

    private static int binarySearch(int[] nums, int target, int start, int end) {
        int mid = (start + end) / 2;
        if (nums[mid] == target)
            return mid;

        if (start >= end)
            return -1;

        return target > nums[mid] ? binarySearch(nums, target, mid + 1, end) :
                binarySearch(nums, target, start, mid);
    }

    public static int findBiggestIndex(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                return i - 1;
            }
        }
        return nums.length - 1;
    }
}
