package com.ds.gfg.arrays.arrangement;

import com.ds.utilities.array.ArrayUtils;

public class DoubleValidFirst {
    // Total Time Complexity (TCC): O(n)
    public static void execute(int[] arr, int n) {
        // base cases
        if (n <= 1) return;

        //Task 1: In valid case, double first & 0 as second
        int start = 0, end = 1;
        // TC: O(n)
        while (end < n) {
            if (arr[start] != 0 && arr[start] == arr[end]) {
                arr[start] = 2 * arr[start];
                arr[end] = 0;
                start += 2;
                end += 2;
            } else {
                start++;
                end++;
            }
        }

        //Task 2: Move all zeros to last
        start = 0;
        //TC: O(n)
        for (end = 0; end < n; end++) {
            if (arr[end] != 0) {
                arr[start++] = arr[end];
            }
        }

        //TC: O(n)
        while (start < n) {
            arr[start++] = 0;
        }
    }

    public static void main(String[] args) {
        int[] input = {0, 2, 2, 2, 0, 6, 6, 0, 0, 8};
        execute(input, input.length);
        System.out.println(ArrayUtils.getArrayAsString(input));
    }
}
