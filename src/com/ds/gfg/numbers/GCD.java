package com.ds.gfg.numbers;

import com.ds.utilities.math.BasicMath;

public class GCD {
    public static int gcd_of_arrays(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res = BasicMath.gcd(res, arr[i]);
            if (res == 1)
                return 1;
        }
        return res;
    }
}
