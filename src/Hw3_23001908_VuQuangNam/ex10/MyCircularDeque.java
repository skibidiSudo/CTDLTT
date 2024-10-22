package Hw3_23001908_VuQuangNam.ex10;

class MyCircularDeque {
    class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    private int maxSize;
    private int size;
    private Node head;
    private Node tail;

    public MyCircularDeque(int k) {
        maxSize = k;
        size = 0;
        head = null;
        tail = null;
    }

    public boolean add(int value) {
        if (isFull()) {
            return false;
        }
        Node node = new Node(value);
        head = tail = node;
        size++;
        return true;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        Node node = new Node(value);
        if (isEmpty()) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        Node node = new Node(value);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
        return true;
    }

    public boolean delete() {
        head = tail = null;
        size = 0;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        if (size == 1) {
            return delete();
        }
        head = head.next;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        if (size == 1) {
            return delete();
        }
        Node node = head;
        while (node.next != tail) {
            node = node.next;
        }
        tail = node;
        tail.next = null;
        size--;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return head.data;
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return tail.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == maxSize;
    }
}