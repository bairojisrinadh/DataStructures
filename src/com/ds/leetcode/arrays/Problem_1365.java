package com.ds.leetcode.arrays;

/* How many numbers are smaller than the current number */
public class Problem_1365 {

    // Input: [8,1,2,2,3]
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        // Base cases
        if(nums == null || nums.length == 0)
            return nums;
        if(nums.length < 2)
            return new int[] {1};

        //Problem constraint: numbers in the input array are in range [0, 100] inclusive;
        int[] bucket = new int[101];

        for (int i = 0; i < nums.length; i++) {
            bucket[nums[i]] += 1;
        }

        //accumulate all the smaller numbers before specific index i;
        for (int i = 1; i < bucket.length; i++) {
            bucket[i] += bucket[i - 1];
        }

        for (int i = 0; i < nums.length; i++) {
            int pos = nums[i];
            nums[i] = pos == 0 ? 0 : bucket[pos - 1];
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {8, 1, 2, 2, 3};
        int[] res = smallerNumbersThanCurrent(nums);
        for (int e: nums) {
            System.out.print(e + " ");
        }
    }
}
