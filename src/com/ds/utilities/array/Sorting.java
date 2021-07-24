package com.ds.utilities.array;

public final class Sorting {

    public static void quickSort(int[] arr) {
        int n = arr.length;
        if (n <= 1) return;
        quickSort(arr, 0, n - 1);
    }

    private static void quickSort(int[] arr, int l, int h) {
        if (l < h) {
            int pivot = partition(arr, l, h);
            quickSort(arr, l, pivot - 1);
            quickSort(arr, pivot + 1, h);
        }
    }

    private static int partition(int[] arr, int l, int h) {
        int pivot = arr[l];
        int i = l;
        int j = h;
        while (i < j) {
            while (i < j && arr[i] <= pivot) i++;
            while (arr[j] > pivot) j--;
            if (i < j) {
                ArrayUtils.swap(arr, i, j);
            }
        }
        ArrayUtils.swap(arr, j, l);
        return j;
    }

    public static void mergeSort(int[] arr) {
        int n = arr.length;
        if (n <= 1) return;
        mergeSort(arr, 0, n - 1);
    }

    private static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int mid = l + (r - l) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int[] b = new int[arr.length];
        int i = l;
        int j = mid + 1;
        int k = l;
        while (i <= mid && j <= r) {
            if (arr[i] < arr[j])
                b[k] = arr[i++];
            else
                b[k] = arr[j++];
            k++;
        }
        if (i > mid) {
            while (j <= r) {
                b[k++] = arr[j++];
            }
        } else {
            while (i <= mid) {
                b[k++] = arr[i++];
            }
        }

        for (k = l; k <= r; k++) {
            arr[k] = b[k];
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 1, 7, 8, 9, 4, 6};
        quickSort(arr);
        ArrayUtils.print(arr);
    }
}
