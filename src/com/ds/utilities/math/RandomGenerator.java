package com.ds.utilities.math;

/* This class used as random generator utility */
public final class RandomGenerator {
    private static final int DEFAULT_UPPER_BOUND = 10;

    public static int randomInt() {
        return randomInt(DEFAULT_UPPER_BOUND);
    }

    public static int randomInt(int bounded_value) {
        // check if bounded_value is +ve or -ve
        boolean isNegative = (((bounded_value >> 31) & 1) == 1);

        double random = Math.floor(Math.random() * bounded_value) + 1;
        return (int) (isNegative ? random + 1 : random);
    }

    public static void main(String[] args) {
        System.out.println(33 >> 4);
    }

}
