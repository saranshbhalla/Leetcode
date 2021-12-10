package com.saranshbhalla.leetcode.medium;

public class ContainerWithMostWater_11 {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea2(height));
    }

    //Brute force
    public static int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++)
            for (int j = i + 1; j < height.length; j++) {
                int minHeight = Math.min(height[i], height[j]);
                maxArea = Math.max(maxArea, minHeight*(j-i));
            }
        return maxArea;
    }

    public static int maxArea2(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length-1;

        while(left<right){
            int minHeight = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, minHeight*(right-left));
            if(height[left]<height[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }
}
