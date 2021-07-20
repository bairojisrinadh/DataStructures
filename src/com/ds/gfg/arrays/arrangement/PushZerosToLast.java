package com.ds.gfg.arrays.arrangement;

import com.ds.utilities.array.ArrayUtils;

public class PushZerosToLast {
    public static void push_zeros_to_last(int[] input) {
        int n = input.length;
        if (n <= 1) return;

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (input[i] != 0)
                input[count++] = input[i];
        }

        while (count < n) {
            input[count++] = 0;
        }
    }

    public static void main(String[] args) {
        int[] input = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};
        push_zeros_to_last(input);
        System.out.println(ArrayUtils.getArrayAsString(input));
    }
}
