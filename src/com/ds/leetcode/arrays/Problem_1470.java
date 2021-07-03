package com.ds.leetcode.arrays;

/* Shuffle the Array */
public class Problem_1470 {
    public static int[] shuffle1(int[] nums, int n) {
        if(nums == null)
            return nums;
        if(nums.length != 2 * n)
            return null;

        for (int i = n, rotation = 1; i < nums.length; i++, rotation++) {
            rotateByOne(nums, i - n + rotation, i);
        }

        return nums;
    }

    private static void rotateByOne(int[] nums, int start, int end) {
        if(end <= start) return;

        int tail = nums[end];
        for (int i = end; i > start; i--) {
            nums[i] = nums[i - 1];
        }
        nums[start] = tail;
    }

    public static int[] shuffle(int[] nums, int n) {
        if(nums == null)
            return nums;
        if(nums.length != 2 * n)
            return null;

        int[] res = new int[2 * n];
        for (int i = 0, first = 0, second = n; i < res.length; i++) {
            if (i % 2 == 0) {
                res[i] = nums[first++];
            } else {
                res[i] = nums[second++];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 5, 1, 3, 4, 7};
        int n = 3;
        int[] res = shuffle(nums, n);
        for (int num : res) {
            System.out.print(num + " ");
        }
    }
}
