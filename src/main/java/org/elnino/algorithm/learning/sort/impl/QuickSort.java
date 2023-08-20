package org.elnino.algorithm.learning.sort.impl;

import org.elnino.algorithm.learning.sort.Sort;

public class QuickSort implements Sort {
    @Override
    public void sort(int[] arr, int left, int right) {
        if (left >= right) return;

        // 1. partition
        int pivot = arr[right];
        int i, j;

        for (i = left, j = right - 1; i <= j; ) {
            if (arr[i] < pivot) {
                i++;
            } else {
                swap(arr, i, j);
                j--; // arr[j] >= pivot, but arr[i] ? pivot, so i should not increment
            }
        }

        // i > j and i points to the first element greater than pivot, swap arr[i] and pivot
        swap(arr, i, right);

        // 2. sort sub-arrays
        sort(arr, left, i - 1);
        sort(arr, i + 1, right);
    }
}
