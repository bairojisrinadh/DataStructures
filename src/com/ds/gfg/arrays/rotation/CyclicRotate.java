package com.ds.gfg.arrays.rotation;

public class CyclicRotate {
    public static int[] rotate_clockwise(int[] input, int n) {
        if (n <= 1) return input;

        int last = input[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            input[i + 1] = input[i];
        }
        input[0] = last;
        return input;
    }

    public static int[] rotate_clockwise_inplace(int[] input, int n) {
        if (n <= 1) return input;
        int tmp, i = 0, j = n - 1;
        while (i != j) {
            tmp = input[i];
            input[i] = input[j];
            input[j] = tmp;
            i++;
        }
        return input;
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5};
        rotate_clockwise_inplace(input, input.length);
        for (int e : input) {
            System.out.print(e + " ");
        }
    }
}
