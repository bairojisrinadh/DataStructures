package com.ds.gfg.arrays.arrangement;

import com.ds.utilities.array.ArrayUtils;

public class NegativePositive {
    public static void first_negatives_second_positives(int[] arr) {
        int n = arr.length;

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
    }

    public static void main(String[] args) {
        int[] input = {2, -1, -5, 4, 3, 1, -9, 0, 2, -5};
        first_negatives_second_positives(input);
        System.out.println(ArrayUtils.getArrayAsString(input));
    }
}
