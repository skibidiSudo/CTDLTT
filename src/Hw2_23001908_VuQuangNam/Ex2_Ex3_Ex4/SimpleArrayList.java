package Hw2_23001908_VuQuangNam.Ex2_Ex3_Ex4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArrayList<T> implements ListInterface<T>, Iterable<T> {
    private T[] array;
    private int n = 0;
    private int defaultSize = 100;

    public SimpleArrayList() {
        array = (T[]) new Object[defaultSize];
    }

    public SimpleArrayList(int capacity) {
        array = (T[]) new Object[capacity];
    }

    @Override
    public void add(T add) {
        if (n == array.length) {
            enlarge();
        }
        array[n++] = add;
    }

    @Override
    public T get(int i) {
        if (checkOutOfRange(i)) {
            throw new IndexOutOfBoundsException();
        }
        return array[i];
    }

    @Override
    public void set(int i, T data) {
        if (checkOutOfRange(i)) {
            throw new IndexOutOfBoundsException();
        }
        array[i] = data;
    }

    @Override
    public void remove(T data) {
        for (int i = 0; i < n; i++) {
            if (array[i].equals(data)) {
                System.arraycopy(array, i + 1, array, i, n - i - 1);
                n--;
                return;
            }
        }
    }

    @Override
    public boolean isContain(T data) {
        for (int i = 0; i < n; i++) {
            if (array[i].equals(data)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    public boolean checkOutOfRange(int i) {
        return i < 0 || i >= n;
    }

    private void enlarge() {
        int newSize = n * 2;
        T[] newArray = (T[]) new Object[newSize];
        System.arraycopy(array, 0, newArray, 0, n);
        array = newArray;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < n;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return array[index++];
            }
        };
    }
}
