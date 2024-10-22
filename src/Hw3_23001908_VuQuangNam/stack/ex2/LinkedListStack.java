package Hw3_23001908_VuQuangNam.stack.ex2;

import java.util.Iterator;

public class LinkedListStack<E> implements StackInterface<E> {
    class Node {
        E element;
        Node next;

        public Node(E element) {
            this.element = element;
            this.next = null;
        }
    }

    private Node stack;

    public LinkedListStack() {
        stack = null;
    }

    @Override
    public void push(E element) {
        Node node = new Node(element);
        if (isEmpty()) {
            stack = node;
            return;
        }
        node.next = stack;
        stack = node;
    }

    @Override
    public E pop() {
        Node node = stack;
        stack = stack.next;
        return node.element;
    }

    @Override
    public boolean isEmpty() {
        return stack == null;
    }

    @Override
    public E top() {
        if (!isEmpty()) {
            return stack.element;
        }
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return new StackIterator();
    }

    class StackIterator implements Iterator<E> {
        private Node currentNode = stack;

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public E next() {
            E data = currentNode.element;
            currentNode = currentNode.next;
            return data;
        }
    }
}
