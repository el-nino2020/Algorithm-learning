package org.elnino.algorithm.learning.sort.impl;

import org.elnino.algorithm.learning.sort.Sort;

public class MergeSort implements Sort {
    @Override
    public void sort(int[] arr, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;

        // sort sub-arrays
        sort(arr, left, mid);
        sort(arr, mid + 1, right);

        // merge 2 sorted sub-arrays
        int i = left, j = mid + 1, k = 0;
        int[] newArray = new int[right - left + 1];

        for (; i <= mid && j <= right; k++) {
            if (arr[i] <= arr[j]) {
                newArray[k] = arr[i];
                i++;
            } else {
                newArray[k] = arr[j];
                j++;
            }
        }

        for (; i <= mid; i++, k++) {
            newArray[k] = arr[i];
        }

        for (; j <= right; j++, k++) {
            newArray[k] = arr[j];
        }

        System.arraycopy(newArray, 0, arr, left, newArray.length);
    }


}
