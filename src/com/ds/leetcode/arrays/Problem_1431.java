package com.ds.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

/* Kids with greatest number of candies */
public class Problem_1431 {

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        if (candies == null) {
            return null;
        }
        int highest_candies = -1;
        for (int i = 0; i < candies.length; i++) {
            if(candies[i] > highest_candies)
                highest_candies = candies[i];
        }

        // In order to avoid '+' operation inside the for loop. i.e., res.add(candies[i] + extraCandies >= highest_candies)
        highest_candies -= extraCandies;

        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            res.add(candies[i] >= highest_candies);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] candies = new int[] {2,3,5,1,3};
        int extraCandies = 3;
        List<Boolean> res = kidsWithCandies(candies, extraCandies);
        for (Boolean item : res) {
            System.out.print(item + ", ");
        }
    }
}

