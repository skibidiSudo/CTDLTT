package Hw5_23001908_VuQuangNam.ex1;

public class SortedArrayPriorityQueue<K extends Comparable<K>, E> implements PriorityQueueInterface<K, E> {

    public static class ArrayEntry<K, E> implements Entry<K, E> {
        K key;
        E value;

        public ArrayEntry(K key, E value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public E getValue() {
            return value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public String toString() {
            return "[" + key + ", " + value + "]";
        }
    }

    protected ArrayEntry<K, E>[] array;
    protected int n;
    protected final int DEFAULT_SIZE = 1000;

    public SortedArrayPriorityQueue() {
        array = new ArrayEntry[DEFAULT_SIZE];
        n = 0;
    }

    public SortedArrayPriorityQueue(int size) {
        array = new ArrayEntry[size];
        n = 0;
    }

    private void enlarge() {
        int size = array.length * 2;
        ArrayEntry<K, E>[] newArray = new ArrayEntry[size];
        System.arraycopy(array, 0, newArray, 0, n);
        array = newArray;
    }

    private void shift(int idx) {
        for (int i = n; i > idx; i--) {
            array[i] = array[i - 1];
        }
    }

    @Override
    public String getName() {
        return "SortedArrayPriorityQueue";
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void insert(Entry<K, E> entry) {
        insert(entry.getKey(), entry.getValue());
    }

    @Override
    public void insert(K k, E e) {
        if (n >= array.length) {
            enlarge();
        }
        ArrayEntry<K, E> newEntry = new ArrayEntry<>(k, e);
        int i = 0;
        while (i < n && array[i].getKey().compareTo(k) < 0) {
            i++;
        }
        shift(i);
        array[i] = newEntry;
        n++;
    }

    @Override
    public Entry<K, E> removeMin() {
        if (isEmpty()) return null;
        Entry<K, E> min = array[0];
        for (int i = 1; i < n; i++) {
            array[i - 1] = array[i];
        }
        array[n - 1] = null;
        n--;
        return min;
    }

    @Override
    public Entry<K, E> min() {
        if (isEmpty()) return null;
        return array[0];
    }
}
