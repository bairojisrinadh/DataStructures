package com.ds.leetcode.arrays;

import java.util.Arrays;

/* Problem Statement: Average salary excluding min. & max. salary */
public class Problem_1491 {
    /**
     * Input: salary = [4000,3000,1000,2000]
     * Output: 2500.00000
     * Explanation: Minimum salary and maximum salary are 1000 and 4000 respectively.
     * Average salary excluding minimum and maximum salary is (2000+3000)/2= 2500
     */

    public static double average(int[] salary) {
        if (salary == null) return 0.0;

        // sort in ascending
        Arrays.sort(salary);

        int length = salary.length;
        if (length == 3) return salary[1];
        double totalSum = 0.0;

        for (int i = 1; i < length - 1; i++) {
            totalSum += salary[i];
        }

        return totalSum / (length - 2);
    }

    public static double average1(int[] salary) {
        if (salary == null) return 0.0;

        int min_sal = Integer.MAX_VALUE;
        int max_sal = Integer.MIN_VALUE;

        int totalSum = 0;
        int length = salary.length;
        for (int i = 0; i < length; i++) {
            if (salary[i] < min_sal)
                min_sal = salary[i];
            if (salary[i] > max_sal)
                max_sal = salary[i];
            totalSum += salary[i];
        }

        return (double) (totalSum - min_sal - max_sal) / (length - 2);
    }

    public static void main(String[] args) {
        int[] salary = {6000, 5000, 4000, 3000, 2000, 1000};
        System.out.println(average1(salary));
    }
}
