package com.ds.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

/* Number of Good Pairs */
public class Problem_1512 {

    //Input: [1,2,3,1,1,3]
    public static int numIdenticalPairs(int[] nums) {
        if(nums == null || nums.length < 2) return 0;
        int counter = 0;
        Map<Integer,Integer> table = new HashMap<>();

        for (int value : nums) {
            if (table.containsKey(value)) {
                counter += table.get(value);
                table.put(value, table.get(value) + 1);
            } else {
                table.put(value, 1);
            }
        }

        return counter;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 1, 3};
        System.out.println(numIdenticalPairs(nums));
    }

}
