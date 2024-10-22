package Hw2_23001908_VuQuangNam.Ex2_Ex3_Ex4;

public class SimpleLinkedList<T> {
    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top = null;
    private Node bot = null;
    private int n = 0;

    public void add(T data) {
        Node newNode = new Node(data);
        if (top == null) {
            top = newNode;
            bot = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        n++;
    }

    public void addBot(T data) {
        Node newNode = new Node(data);
        if (bot == null) {
            top = newNode;
            bot = newNode;
        } else {
            bot.next = newNode;
            bot = newNode;
        }
        n++;
    }

    public T get(int i) {
        if (i < 0 || i >= n) {
            throw new IndexOutOfBoundsException();
        }
        Node current = top;
        for (int index = 0; index < i; index++) {
            current = current.next;
        }
        return current.data;
    }

    public void set(int i, T data) {
        if (i < 0 || i >= n) {
            throw new IndexOutOfBoundsException();
        }
        Node current = top;
        for (int index = 0; index < i; index++) {
            current = current.next;
        }
        current.data = data;
    }

    public boolean isContain(T data) {
        Node current = top;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public T removeTop() {
        if (top == null) {
            return null;
        }
        T data = top.data;
        top = top.next;
        if (top == null) {
            bot = null;
        }
        n--;
        return data;
    }

    public T removeBot() {
        if (bot == null) {
            return null;
        }
        if (top == bot) {
            T data = bot.data;
            top = bot = null;
            n--;
            return data;
        }
        Node current = top;
        while (current.next != bot) {
            current = current.next;
        }
        T data = bot.data;
        bot = current;
        bot.next = null;
        n--;
        return data;
    }

    public void remove(T data) {
        if (top == null) {
            return;
        }
        if (top.data.equals(data)) {
            removeTop();
            return;
        }
        Node current = top;
        while (current.next != null && !current.next.data.equals(data)) {
            current = current.next;
        }
        if (current.next != null) {
            if (current.next == bot) {
                bot = current;
            }
            current.next = current.next.next;
            n--;
        }
    }
}
