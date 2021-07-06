package com.ds.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Problem Statement: Minimum Absolute Difference */
public class Problem_1200 {

    /**
     * Input: arr = [4,2,1,3]
     * Output: [[1,2],[2,3],[3,4]]
     * Explanation: The minimum absolute difference is 1. List all pairs with difference equal to 1 in ascending order.
     */

    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        // sort input array in ascending order
        Arrays.sort(arr);
        int diff = Integer.MAX_VALUE;
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < arr.length - 1; i++) {
            int newDiff = Math.abs(arr[i + 1] - arr[i]);
            if (newDiff <= diff) {
                if (newDiff < diff) {
                    result.clear();
                    diff = newDiff;
                }
                result.add(List.of(arr[i], arr[i + 1]));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{40, 11, 26, 27, -20};
        // -20, 11, 26, 27, 40 - sorted array
        List<List<Integer>> res = minimumAbsDifference(arr);
        int count = 0;
        System.out.print("[");
        for (List<Integer> pair : res) {
            count++;
            System.out.print("[" + pair.get(0) + "," + pair.get(1) + "]");
            if (count != res.size())
                System.out.print(",");
        }
        System.out.print("]");
    }
}
