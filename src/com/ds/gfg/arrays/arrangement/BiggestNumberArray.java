package com.ds.gfg.arrays.arrangement;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BiggestNumberArray {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(54, 546, 548, 60);
        Collections.sort(input, new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                Integer combine_xy = Integer.valueOf(x + "" + y);
                Integer combine_yx = Integer.valueOf(y + "" + x);
                return combine_xy == combine_yx ? 0 : combine_yx > combine_xy ? 1 : -1;
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int e : input) {
            sb.append(e);
        }
        System.out.println("Biggest Number: " + sb.toString());
    }
}
