package org.elnino.algorithm.learning.sort;

import org.elnino.algorithm.learning.sort.impl.*;
import org.junit.Test;


import static org.junit.Assert.*;

public class SortTest {

    @Test
    public void selectionSortTest() {
        sortTest(new SelectionSort(), 100, 10000);
    }

    @Test
    public void InsertionSortTest() {
        sortTest(new InsertionSort(), 100, 10000);
    }

    @Test
    public void mergeSortTest() {
        sortTest(new MergeSort(), 100, 10000);
    }

    @Test
    public void quickSortTest() {
        sortTest(new QuickSort(), 100, 10000);
    }

    @Test
    public void heapSortTest() {
        sortTest(new HeapSort(), 100, 10000);
    }

    public void sortTest(Sort sort, int round, int length) {
        int[] arr = new int[length];

        long start = System.currentTimeMillis();

        for (int j = 0; j < round; j++) {
            for (int i = 0; i < length; i++) {
                arr[i] = (int) (Math.random() * length * 5);
            }
            sort.sort(arr);

            for (int i = 0; i < length - 1; i++) {
                assertTrue(arr[i] <= arr[i + 1]);
            }
        }

        long end = System.currentTimeMillis();

        System.out.print(sort.getClass().getSimpleName() + ", round=" + round + ", arrLength=" + length);
        System.out.println(", take " + (end - start) + "ms");

    }


}