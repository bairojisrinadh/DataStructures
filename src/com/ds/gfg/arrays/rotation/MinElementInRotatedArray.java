package com.ds.gfg.arrays.rotation;

public class MinElementInRotatedArray {
    //we can retrieve the min. element in any array by traversing through it at O(n) complexity. But, can we achieve it by a binary
    // search complexity i.e., O(log n)
    public static int find_min_in_rotated_array(int[] input, int n) {
        if (n == 1) return input[0];
        return find_min_in_rotated_array(input, 0, n - 1);
    }

    private static int find_min_in_rotated_array(int[] input, int low, int high) {
        // This condition is needed to handle the case when array is not rotated at all
        if (high < low) return input[0];

        // If there is only one element left
        if (high == low) return input[low];

        int mid = low + ((high - low) / 2);

        // Check if element (mid+1) is minimum element. Consider the cases like {3, 4, 5, 1, 2}
        if (mid < high && input[mid + 1] < input[mid])
            return input[mid + 1];

        // Check if mid itself is minimum element
        if (mid > low && input[mid] < input[mid - 1])
            return input[mid];

        // Decide whether we need to go to left half or right half
        if (input[high] > input[mid])
            return find_min_in_rotated_array(input, low, mid - 1);

        return find_min_in_rotated_array(input, mid + 1, high);
    }

    public static void main(String[] args) {
        int[] input = {2, 3, 4, 5, 6, 7, 8, 1};
        System.out.println(find_min_in_rotated_array(input, input.length));
    }
}
