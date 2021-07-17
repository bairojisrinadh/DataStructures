package com.ds.gfg.arrays.rotation;

import com.ds.utilities.math.BasicMath;

public class ArrayRotation {

    // Time Complexity: O(n); Auxiliary Space: O(d)
    public static int[] rotateUsingTemp(int[] input, int d, int n) {
        if (n == 0 || n == 1 || n == d) return input;

        // store initial d elements in tmp array
        int[] tmp = new int[d];
        for (int i = 0; i < d; i++) {
            tmp[i] = input[i];
        }

        // copy elements from d idx to 0 idx
        for (int i = d, j = 0; i < n; i++, j++) {
            input[j] = input[i];
        }

        for (int i = n - d, j = 0; i < n; i++, j++) {
            input[i] = tmp[j];
        }

        return input;
    }

    // Time Complexity: O (d * n)
    public static int[] rotateInPlace(int[] input, int d, int n) {
        if (n == 0 || n == 1 || n == d) return input;

        if (d > (n / 2)) {
            d = n - d;
        }

        for (int i = 0; i < d; i++) {
            left_rotate(input, input.length);
        }

        return input;
    }

    public static int[] jugglingAlgorithm(int[] input, int d, int n) {
        if (n == 0 || n == 1 || n == d) return input;

        // handle if d greater than n
        d = d % n;
        int i, j, k, tmp;
        int gcd = BasicMath.gcd(n, d);

        for (i = 0; i < gcd; i++) {
            tmp = input[i];
            j = i;
            while (true) {
                k = j + d;
                if (k >= n) {
                    k = k - n;
                }
                if (k == i) {
                    break;
                }
                input[j] = input[k];
                j = k;
            }
            input[j] = tmp;
        }

        return input;
    }

    private static void left_rotate(int[] input, int n) {
        int tmp = input[0];
        for (int i = 1; i < n; i++) {
            input[i - 1] = input[i];
        }
        input[n - 1] = tmp;
    }

    public static void main(String[] args) {
        int[] res = jugglingAlgorithm(new int[]{1, 2, 3, 4, 5, 6, 7}, 2, 7);
        for (int e : res) {
            System.out.print(e + " ");
        }
    }
}
