package Hw3_23001908_VuQuangNam.queue.ex1;

import java.util.Iterator;

public class ArrayQueue<E> implements QueueInterface<E> {
    private E[] queue;
    private int n;
    private int top;
    private int count;
    private final int DEFAULT_SIZE = 100;

    public ArrayQueue(int capacity) {
        n = capacity;
        top = 0;
        count = 0;
        queue = (E[]) new Object[capacity];
    }

    public ArrayQueue() {
        n = DEFAULT_SIZE;
        top = 0;
        count = 0;
        queue = (E[]) new Object[DEFAULT_SIZE];
    }

    @Override
    public void enqueue(E element) {
        if (count == n) {
            enlarge();
        }
        int rear = (top + count) % n;
        queue[rear] = element;
        count++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            return null;
        }
        E data = queue[top];
        queue[top] = null;
        top = (top + 1) % n;
        count--;
        return data;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    public void enlarge() {
        E[] newQueue = (E[]) new Object[n * 2];
        for (int i = 0; i < count; i++) {
            newQueue[i] = queue[(top + i) % n];
        }
        queue = newQueue;
        top = 0;
        n = n * 2;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayQueueIterator();
    }

    class ArrayQueueIterator implements Iterator<E> {
        private int current = top;
        private int num = 0;

        @Override
        public boolean hasNext() {
            return num < count;
        }

        @Override
        public E next() {
            E data = queue[(current + num) % n];
            num++;
            return data;
        }
    }
}
