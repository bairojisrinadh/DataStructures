package com.ds.gfg.arrays.rotation;

public class MaxHammingDistance {
    public static int find_rotation_with_max_hamming_distance(int[] input, int n) {
        if (n <= 1) return 0;

        // create new array whose size is twice of input size & copy same array in 2nd half
        int[] dup = new int[n * 2];

        int i = 0;
        while (i < dup.length) {
            dup[i] = input[i % n];
            i++;
        }

        i = 1;
        int max_distance = Integer.MIN_VALUE;

        for (; i < n; i++) {
            int hamming_count = 0;
            for (int j = i, k = 0; j < (i + n); j++, k++) {
                if (dup[j] != input[k]) {
                    hamming_count++;
                }
            }
            // We can never get more than n.
            if (hamming_count == n)
                return n;

            System.out.println("break");
            max_distance = Math.max(max_distance, hamming_count);
        }

        return max_distance;
    }

    public static void main(String[] args) {
        int[] input = {2, 4, 8, 0};
        System.out.println(find_rotation_with_max_hamming_distance(input, input.length));
    }
}
