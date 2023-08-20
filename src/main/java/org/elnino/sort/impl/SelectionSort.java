package org.elnino.sort.impl;

import org.elnino.sort.Sort;

public class SelectionSort implements Sort {
    @Override
    public void sort(int[] arr, int left, int right) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;

            for (int j = i; j < n; j++) {
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }

            swap(arr, i, minIndex);
        }
    }
}
