package Hw5_23001908_VuQuangNam.ex1;

public class UnsortedArrayPriorityQueue<K extends Comparable<K>, E> implements PriorityQueueInterface<K, E> {
    protected class ArrEntry<K, E> implements Entry<K, E> {
        K key;
        E element;

        public ArrEntry(K k, E e) {
            this.key = k;
            this.element = e;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public E getValue() {
            return element;
        }
    }

    private ArrEntry<K, E>[] array;
    private int n;
    private final int DEFAULT_SIZE = 1000;

    public UnsortedArrayPriorityQueue() {
        array = new ArrEntry[DEFAULT_SIZE];
        n = 0;
    }

    public UnsortedArrayPriorityQueue(int size) {
        array = new ArrEntry[size];
        n = 0;
    }

    private void enlarge() {
        int size = array.length * 2;
        ArrEntry<K, E>[] newArray = new ArrEntry[size];
        System.arraycopy(array, 0, newArray, 0, n);
        array = newArray;
    }

    private boolean checkOutOfRange(int idx) {
        return 0 > idx || idx >= array.length;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public void insert(K k, E e) {
        if (n >= array.length) {
            enlarge();
        }
        array[n++] = new ArrEntry<>(k, e);
    }

    @Override
    public void insert(Entry<K, E> entry) {
        insert(entry.getKey(), entry.getValue());
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Entry<K, E> min() {
        if (isEmpty()) return null;
        ArrEntry<K, E> min = array[0];
        for (int i = 1; i < n; i++) {
            if (array[i].getKey().compareTo(min.getKey()) < 0) {
                min = array[i];
            }
        }
        return min;
    }

    @Override
    public Entry<K, E> removeMin() {
        if (isEmpty()) return null;
        int minIdx = 0;
        for (int i = 1; i < n; i++) {
            if (array[i].getKey().compareTo(array[minIdx].getKey()) < 0) {
                minIdx = i;
            }
        }
        ArrEntry<K, E> minEntry = array[minIdx];
        array[minIdx] = array[n - 1];
        array[n - 1] = null;
        n--;
        return minEntry;
    }



    private void swap(int i, int j) {
        ArrEntry<K, E> temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

