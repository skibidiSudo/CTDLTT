package Hw3_23001908_VuQuangNam.queue.ex1;

import java.util.Iterator;

public class LinkedListQueue<E> implements QueueInterface<E> {
    class Node {
        E data;
        Node next;

        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

    public LinkedListQueue() {
        head = null;
        tail = null;
    }

    @Override
    public void enqueue(E data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            return null;
        }
        Node node = head;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return node.data;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListQueueIterator();
    }

    class LinkedListQueueIterator implements Iterator<E> {
        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (hasNext()) {
                Node node = current;
                current = current.next;
                return node.data;
            }
            return null;
        }
    }
}
