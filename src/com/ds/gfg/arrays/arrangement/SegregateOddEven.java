package com.ds.gfg.arrays.arrangement;

import com.ds.utilities.array.ArrayUtils;

public class SegregateOddEven {
    public static void execute(int[] arr) {
        int n = arr.length;

        if (n <= 1) return;

        int i = 0, tmp = 0;
        for (int j = 0; j < n; j++) {
            if (arr[j] % 2 == 0) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] input = {1, 3, 2, 4, 7, 6, 9, 10};
        execute(input);
        System.out.println(ArrayUtils.getArrayAsString(input));
    }
}
