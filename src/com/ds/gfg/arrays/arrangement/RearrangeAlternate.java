package com.ds.gfg.arrays.arrangement;

import com.ds.utilities.array.ArrayUtils;

import java.util.Arrays;

public class RearrangeAlternate {
    // Total Time Complexity: O(n log n) + O(n) = O(n log n); Auxiliary Space Complexity: O(n)
    public static int[] rearrange_alternate(int[] arr, int n) {
        if (n <= 1) return arr;

        // sort input array. O(n log n)
        Arrays.sort(arr);

        int low = 0, high = n - 1;
        int res[] = new int[n];

        // O(n)
        for (int j = n - 1; j >= 0; j--) {
            if (j % 2 == 0)
                res[j] = arr[low++];
            else
                res[j] = arr[high--];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 1, 4, 5, 6, 8, 8};
        int res[] = rearrange_alternate(input, input.length);
        System.out.println(ArrayUtils.getArrayAsString(res));
    }
}
