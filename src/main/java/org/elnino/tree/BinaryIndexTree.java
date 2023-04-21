package org.elnino.tree;

/**
 * A Fenwick tree or binary indexed tree (BIT) is a data structure
 * that can update elements and calculate prefix sums in O(log(n)) time in
 * a given array of size n.  <br/><br/>
 * <p>
 * In Chinese, a BIT is also known as <a href="https://baike.baidu.com/item/%E6%A0%91%E7%8A%B6%E6%95%B0%E7%BB%84">树状数组</a>.
 * <p>
 * @see <a href="https://en.wikipedia.org/wiki/Fenwick_tree">wikipedia</a>
 */
@SuppressWarnings({"unused"})
public class BinaryIndexTree {

    /**
     * BIT can be implemented using an array
     */
    private final int[] tree;
    /**
     * the original array
     */
    private final int[] arr;

    /**
     * return the last set bit of i
     */
    private int lsb(int i) {
        return i & -i;
    }

    /**
     * Essentially, what the method does is the same as <code> arr[i] += delta</code> <br/>
     * The time complexity is O(log(n)).
     */
    private void add(int i, int delta) {
        for (; i < tree.length; i += lsb(i))
            tree[i] += delta;
    }

    /**
     * The time complexity is O(log(n)).
     *
     * @return the prefix sum at i, i.e., sum(arr[0], ..., arr[i])
     */
    private int prefixSum(int i) {
        int ans = 0;
        for (; i > 0; i -= lsb(i))
            ans += tree[i];
        return ans;
    }

    /**
     * initialize the BIT with <code>arr</code> of size n. <br/>
     * The time complexity is O(nlog(n)).
     *
     * @param arr the original array
     */
    public BinaryIndexTree(int[] arr) {
        this.arr = arr;
        int n = arr.length;
        // we need an implicit node 0 at the root
        this.tree = new int[n + 1];

        for (int i = 0; i < n; i++) {
            add(i + 1, arr[i]);
        }
    }

    /**
     * The time complexity is O(log(n)).
     *
     * @return sum(arr[left], ..., arr[right])
     */
    public int rangeSum(int left, int right) {
        return prefixSum(right + 1) - prefixSum(left);
    }

    /**
     * The time complexity is O(log(n)).
     *
     * @see java.util.List#set(int, Object)
     */
    public void set(int index, int val) {
        add(index + 1, val - arr[index]);
        arr[index] = val;
    }

    /**
     * @see java.util.List#get(int)
     */
    public int get(int index) {
        return arr[index];
    }
}
