package com.ds.gfg.arrays.arrangement;

public class MinSwaps {
    public static int min_swaps(int[] input, int k) {
        if (input == null || input.length <= 1) return 0;

        int n = input.length;

        //find no. of elements <= k
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (input[i] <= k)
                count++;
        }

        int bad = 0;
        for (int i = 0; i < count; i++) {
            if (input[i] > k)
                bad++;
        }

        int min_swaps = bad;

        //sliding window of fixed length, count
        for (int i = 0, j = count; j < n; i++, j++) {
            if (input[i] > k)
                bad--;
            if (input[j] > k)
                bad++;
            min_swaps = Math.min(min_swaps, bad);
        }

        return min_swaps;
    }

    public static void main(String[] args) {
        int input[] = {2, 7, 9, 5, 8, 7, 4};
        int k = 5;
        System.out.println(min_swaps(input, k));
    }
}
