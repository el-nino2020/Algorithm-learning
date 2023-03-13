package org.elnino.sort.impl;

import org.elnino.sort.Sort;

public class InsertionSort implements Sort {
    @Override
    public void sort(int[] arr, int left, int right) {
        int n = arr.length;

        for (int j = 0; j < n; j++) {
            int i = j;
            while (i >= 1 && arr[i] < arr[i - 1]) {
                swap(arr, i, i - 1);
                i--;
            }
        }
    }
}
