package com.ds.gfg.arrays.arrangement;

import com.ds.utilities.array.ArrayUtils;

public class RearrangeArray {
    public static void rearrange(int[] input, int n) {
        if (n <= 1) return;

        for (int i = 0; i < n; i++) {
            if (input[i] != -1 && input[i] != i) {
                int x = input[i];

                // check if desired place is not vacate
                while (input[x] != -1 && input[x] != x) {
                    // store the value from desired place
                    int y = input[x];
                    // place the x to its correct position
                    input[x] = x;
                    // now y will become x, now search the place for x
                    x = y;
                }

                // place the x to its correct position
                input[x] = x;

                if (input[i] != i) {
                    // if not then put -1 at the vacated place
                    input[i] = -1;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] input = {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1};
        rearrange(input, input.length);
        System.out.println(ArrayUtils.getArrayAsString(input));
    }
}
