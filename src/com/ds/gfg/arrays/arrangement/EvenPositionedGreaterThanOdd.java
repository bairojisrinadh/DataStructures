package com.ds.gfg.arrays.arrangement;

import com.ds.utilities.array.ArrayUtils;

import java.util.Arrays;

public class EvenPositionedGreaterThanOdd {
    // Time Complexity: O(n log n) as we are using sorting, Auxiliary Space Complexity: O(n)
    public static int[] rearrange_even_positioned_greater(int[] arr) {
        int n = arr.length;

        if (n <= 1) return arr;

        // sort the array in ascending order
        Arrays.sort(arr);

        int[] res = new int[n];

        for (int i = 0, p = 0, q = n - 1; i < n; i++) {
            // Assign even indexes with maximum elements
            if ((i + 1) % 2 == 0)
                res[i] = arr[q--];
                // Assign odd indexes with remaining elements
            else
                res[i] = arr[p++];
        }

        return res;
    }

    // Time Complexity: O(n), Auxiliary Space Complexity: O(1)
    public static void rearrange_even_positioned_greater_1(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            // if index is even
            if (i % 2 == 0) {
                if (arr[i] > arr[i - 1]) {

                    // swap two elements
                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                }
            }
            // if index is odd
            else {
                if (arr[i] < arr[i - 1]) {
                    // swap two elements
                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] input = {1, 3, 2, 2, 5};
        rearrange_even_positioned_greater_1(input, input.length);
        System.out.println(ArrayUtils.getArrayAsString(input));
    }
}
