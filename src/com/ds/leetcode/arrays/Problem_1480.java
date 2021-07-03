package com.ds.leetcode.arrays;

/* Running Sum of 1D Array */
public class Problem_1480 {
    public static int[] runningSum(int[] nums) {
        if(nums == null || nums.length < 0)
            return null;
        if(nums.length < 2)
            return nums;

        int[] res = new int[nums.length];
        res[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] + nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] res = runningSum(nums);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
