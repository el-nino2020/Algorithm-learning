package org.elnino.sort;

import org.elnino.sort.impl.SelectionSort;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class SortTest {

    @Test
    public void selectionSortTest() {
        sortTest(new SelectionSort(), 100, 10000);
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