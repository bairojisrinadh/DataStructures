package com.ds.utilities.math;

public final class BasicMath {
    public static int naive_gcd(int a, int b) {
        if (a < 1 || b < 1)
            throw new IllegalArgumentException("cannot get gcd of negative numbers");

        int gcd = 1;
        // Making sure, a is smaller & b is larger
        if (a > b) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        for (int i = 2; i <= (b / 2); i++) {
            if ((a % i == 0) && (b % i == 0)) {
                gcd = i;
            }
        }

        return gcd;
    }

    // Time Complexity: O(log(min(a, b)))
    public static int gcd(int a, int b) {
        if (a < 0 || b < 0)
            throw new IllegalArgumentException("cannot get gcd of negative numbers");

        if (a == 0) return b;
        if (b == 0) return a;

        // make sure a is always less then b
        if (a > b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        return concrete_gcd(a, b);
    }

    private static int concrete_gcd(int a, int b) {
        if (a == 0) return b;
        return concrete_gcd(b % a, a);
    }
}
