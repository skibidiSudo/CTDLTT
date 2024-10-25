package Hw5_23001908_VuQuangNam.ex2;

import Hw5_23001908_VuQuangNam.ex1.Entry;
import Hw5_23001908_VuQuangNam.ex1.SortedArrayPriorityQueue;

public class MinHeapPriorityQueue<K extends Comparable<K>, E> extends SortedArrayPriorityQueue<K, E> {
    private ArrayEntry<K, E>[] heapPQ;
    private int n;

    public MinHeapPriorityQueue() {
        heapPQ = new ArrayEntry[DEFAULT_SIZE];
        n = 0;
    }

    public MinHeapPriorityQueue(int size) {
        heapPQ = new ArrayEntry[size + 1];
        n = 0;
    }

    protected void upHeap(int idx) {
        while (idx > 1 && heapPQ[idx / 2].getKey().compareTo(heapPQ[idx].getKey()) > 0) {
            swap(idx, idx / 2);
            idx /= 2;
        }
    }

    protected void downHeap(int idx) {
        while (2 * idx <= n) {
            int j = 2 * idx;
            if (j < n && heapPQ[j].getKey().compareTo(heapPQ[j + 1].getKey()) > 0) {
                j++;
            }
            if (heapPQ[idx].getKey().compareTo(heapPQ[j].getKey()) <= 0) {
                break;
            }
            swap(idx, j);
            idx = j;
        }
    }

    private void swap(int i, int j) {
        ArrayEntry<K, E> temp = heapPQ[i];
        heapPQ[i] = heapPQ[j];
        heapPQ[j] = temp;
    }

    @Override
    public Entry<K, E> removeMin() {
        if (isEmpty()) return null;
        Entry<K, E> min = heapPQ[1];
        heapPQ[1] = heapPQ[n];
        heapPQ[n] = null;
        n--;
        downHeap(1);
        return min;
    }

    @Override
    public Entry<K, E> min() {
        if (isEmpty()) return null;
        return heapPQ[1];
    }

    @Override
    public void insert(Entry<K, E> entry) {
        if (n + 1 >= heapPQ.length) enlarge();
        n++;
        heapPQ[n] = (ArrayEntry<K, E>) entry;
        upHeap(n);
    }

    @Override
    public void insert(K k, E e) {
        insert(new ArrayEntry<>(k, e));
    }

    @Override
    public String getName() {
        return "MinHeapPriorityQueue";
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    private void enlarge() {
        int newSize = heapPQ.length * 2;
        ArrayEntry<K, E>[] newArray = new ArrayEntry[newSize];
        System.arraycopy(heapPQ, 1, newArray, 1, n);
        heapPQ = newArray;
    }
}
