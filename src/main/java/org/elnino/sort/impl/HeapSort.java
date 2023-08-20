package org.elnino.sort.impl;

import org.elnino.sort.Sort;

public class HeapSort implements Sort {
    @Override
    public void sort(int[] arr, int left, int right) {
        // 1. heapify: make arr to a max heap
        // Max heap: the value of a node >= the values of its children
        int n = arr.length;
        for (int i = n - 1; i >= 0; i--) {
            sink(arr, i, n);
        }

        // 2. heap sort
        for (int i = n - 1; i >= 0; i--) {
            // the swap step make sure that arr[i : n - 1] is sorted
            swap(arr, 0, i);
            sink(arr, 0, i);
        }
    }

    /**
     * if the value of the node is less than one of its children, sink it down.
     *
     * @param arr   heap represented by array
     * @param index the node to sink
     * @param len   size of the heap
     */
    private void sink(int[] arr, int index, int len) {
        for (; index < len; ) {
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;

            // find the node with the biggest value among arr[index] and its children (if any)
            int maxIndex = index;
            if (leftChild < len && arr[leftChild] > arr[maxIndex]) maxIndex = leftChild;
            if (rightChild < len && arr[rightChild] > arr[maxIndex]) maxIndex = rightChild;

            // no need to sink
            if (maxIndex == index) break;

            swap(arr, index, maxIndex);
            // continue to sink this node
            index = maxIndex;
        }
    }
}
