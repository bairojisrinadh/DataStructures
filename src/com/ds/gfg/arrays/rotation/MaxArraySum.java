package com.ds.gfg.arrays.rotation;

public class MaxArraySum {
    public static int max_arr_sum(int[] input, int n) {
        if (n <= 1) return 0;

        int arrSum = 0;
        int currValue = 0;

        // calculate initial sum of R0 & arrSum
        for (int i = 0; i < n; i++) {
            arrSum += input[i];
            currValue += (i * input[i]);
        }

        int maxValue = currValue;

        // Evaluated formula based on pattern found
        for (int j = 1; j < n; j++) {
            currValue += arrSum - (n * input[n - j]);
            if (currValue > maxValue)
                maxValue = currValue;
        }

        return maxValue;
    }

    public static void main(String[] args) {
        int[] input = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(max_arr_sum(input, input.length));
    }
}
