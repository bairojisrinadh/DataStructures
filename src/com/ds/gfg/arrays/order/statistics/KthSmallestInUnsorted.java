package com.ds.gfg.arrays.order.statistics;

import java.util.Arrays;

public class KthSmallestInUnsorted {
    public static void main(String[] args) {
        int[] input = {7, 10, 4, 3, 20, 15};
        int kth = 4;
        int res = brute_force(input, kth);
        System.out.println(res);
    }

    // TTC: O(n log n) sorting complexity
    private static int brute_force(int[] input, int kth) {
        int n = input.length;

        if (kth > n - 1) {
            System.out.println("k cannot be greater than size of an array (n)");
            return -1;
        }

        // sort array in ascending order
        Arrays.sort(input);

        return input[kth - 1];
    }
}
