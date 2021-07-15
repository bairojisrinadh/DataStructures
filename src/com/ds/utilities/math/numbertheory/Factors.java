package com.ds.utilities.math.numbertheory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Factors {

    public static List<Integer> getAllPrimeFactors(int n) {
        if (n < 2) throw new IllegalArgumentException("cannot get prime factors for 0, 1 or negative numbers");
        if (n == 2 || n == 3) {
            return Arrays.asList(n);
        }

        List<Integer> primeFactors = new ArrayList<>();
        //list probable times of only even prime i.e., 2
        while (n % 2 == 0) {
            primeFactors.add(2);
            n /= 2;
        }

        //n must be odd at this point. loop through all possible composite numbers
        for (int i = 3; i < Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                primeFactors.add(i);
                n /= i;
            }
        }

        //last condition is to handle where n is a prime number left out which is greater than 2
        if (n > 2)
            primeFactors.add(n);

        return primeFactors;
    }
}
