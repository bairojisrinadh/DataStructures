package com.ds.utilities.algo;

public class Searching {
    public static int binary_search(int[] input, int low, int high, int key) {
        // base case: if key not found, return -1;
        if (low == high && input[low] != key) return -1;

        int mid = low + ((high - low) / 2);

        if (key == input[mid])
            return mid;
        else if (key < input[mid])
            return binary_search(input, low, mid - 1, key);
        else
            return binary_search(input, mid + 1, high, key);
    }

    public static void main(String[] args) {
        System.out.println(binary_search(new int[]{1, 2, 3, 4, 5}, 0, 4, 9));
    }
}
