package com.ds.gfg.arrays.arrangement;

import com.ds.utilities.array.ArrayUtils;

public class RearrangeAlternativeEfficient {
    public static void rearrange_efficient(int[] arr, int n) {
        if (n <= 1) return;

        int i = -1, tmp = 0;
        for (int j = 0; j < n; j++) {
            if (arr[j] < 0) {
                ++i;
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }

        int positive_idx = i + 1, negative_idx = 0;

        while (positive_idx < n && negative_idx < positive_idx && arr[negative_idx] < 0) {
            tmp = arr[negative_idx];
            arr[negative_idx] = arr[positive_idx];
            arr[positive_idx] = tmp;
            positive_idx++;
            negative_idx += 2;
        }
    }

    public static void main(String[] args) {
        int[] input = {-1, 2, -3, 4, 5, 6, -7, 8, 9};
        rearrange_efficient(input, input.length);
        System.out.println(ArrayUtils.getArrayAsString(input));
    }
}
