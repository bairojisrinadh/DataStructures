package com.ds.utilities.array;

public final class ArrayUtils {
    public static String getArrayAsString(int[] arr) {
        if (arr == null) return null;

        int length = arr.length;
        if (length == 0) return "[]";
        if (length == 1) return "[" + arr[0] + "]";

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < length; i++) {
            if (i == length - 1) {
                sb.append(arr[i]).append("]");
                break;
            }
            sb.append(arr[i]).append(", ");
        }

        return sb.toString();
    }

    public static void print(int[] arr) {
        System.out.println(getArrayAsString(arr));
    }

    public static void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
}
