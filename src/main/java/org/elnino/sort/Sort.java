package org.elnino.sort;

public interface Sort {
    default void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    /**
     * sort arr[left: right]
     *
     * @param arr   array to be sort
     * @param left  left bound of the interval, inclusive
     * @param right right bound of the interval, inclusive
     */
    void sort(int[] arr, int left, int right);

    /**
     * a helper method for swapping {@code arr[i]} and {@code arr[j]} <br/>
     * note that this method will not check whether {@code i, j, arr} are valid
     */
    default void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
