package Hw3_23001908_VuQuangNam.stack.ex2;

import java.util.Iterator;

public class ArrayStack<E> implements StackInterface<E> {
    private E[] stack;
    private final int DEFAULT_SIZE = 16;
    private int index;

    public ArrayStack() {
        stack = (E[]) new Object[DEFAULT_SIZE];
        index = -1;
    }

    public ArrayStack(int size) {
        stack = (E[]) new Object[size];
        index = -1;
    }

    @Override
    public boolean isEmpty() {
        return index == -1;
    }

    @Override
    public void push(E element) {
        if (index + 1 >= stack.length) {
            enlarge();
        }
        stack[++index] = element;
    }

    @Override
    public E top() {
        if (isEmpty()) {
            return null;
        }
        return stack[index];
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        return stack[index--];
    }

    public void enlarge() {
        int newSize = (index + 1) * 2;
        E[] newStack = (E[]) new Object[newSize];
        System.arraycopy(stack, 0, newStack, 0, index + 1);
        stack = newStack;
    }

    @Override
    public Iterator<E> iterator() {
        return new StackArrayIterator();
    }

    class StackArrayIterator implements Iterator<E> {
        private int i = index;
        @Override
        public boolean hasNext() {
            return i >= 0;
        }

        @Override
        public E next() {
            return stack[i--];
        }
    }
}
