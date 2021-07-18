package com.ds.gfg.arrays.rotation;

import com.ds.utilities.algo.Searching;

public class SearchInPivotedArray {
    public static int search_in_pivoted_array(int[] input, int n, int key) {
        if (n < 1) return -1;
        else if (n == 1) return input[0] != key ? -1 : 0;

        //find pivot; as provided array is pivoted ascending array, thus at some index, value after index will be less than current
        // index value
        int pivot_idx = -1;
        int i = 0;
        while (i < n) {
            if (input[i] > input[i + 1]) {
                pivot_idx = i;
                break;
            }
            i++;
        }

        // provided input is normal ascending ordered array
        if (pivot_idx == -1) {
            return Searching.binary_search(input, 0, n - 1, key);
        } else {
            if (input[0] > key)
                return Searching.binary_search(input, pivot_idx + 1, n, key);
            else
                return Searching.binary_search(input, 0, pivot_idx, key);
        }
    }

    public static void main(String[] args) {
        int[] input = {30, 40, 50, 10, 20};
        int key = 10;
        System.out.println(search_in_pivoted_array(input, input.length, key));
    }
}
