package com.ds.leetcode.arrays;

/* Problem Statement: find N unique integers sum up to zero */
public class Problem_1304 {
    /**
     * Input: n = 5
     * Output: [-7,-1,1,3,4]
     * Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
     */

    public static int[] sumZero(int n) {
        int[] result = new int[n];
        for (int i = 0; i < n - 1; i += 2) {
            result[i] = i + 1;
            result[i + 1] = -(i + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] res = sumZero(3);
        for (int val : res) {
            System.out.print(val + " ");
        }
    }
}
