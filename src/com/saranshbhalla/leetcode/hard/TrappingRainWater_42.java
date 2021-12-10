package com.saranshbhalla.leetcode.hard;

public class TrappingRainWater_42 {
    public static void main(String[] args) {
        System.out.println(trap(new int[]{2,0,1, 4}));
    }

    public static int trap(int[] height) {
        if (height.length < 3)
            return 0;
        int head = 0;
        int tail = height.length - 1;
        int waterStored = 0;
        int minLevel = Math.min(height[head], height[tail]);

        while (head < tail) {
            if (height[head] < height[tail]) {
                head++;
                if (height[head] < minLevel)
                    waterStored = waterStored + (minLevel - height[head]);
                else
                    minLevel = Math.min(height[head], height[tail]);
            } else {
                tail--;
                if (height[tail] < minLevel)
                    waterStored = waterStored + (minLevel - height[tail]);
                else
                    minLevel = Math.min(height[head], height[tail]);
            }
        }
        return waterStored;
    }
}
