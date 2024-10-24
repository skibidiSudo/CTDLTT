package Hw5_23001908_VuQuangNam.ex1;

public class SortedLinkedPriorityQueue<K extends Comparable<K>, E> implements PriorityQueueInterface<K, E> {
    protected class NodeEntry<K, E> implements Entry<K, E> {
        private K key;
        private E value;
        private NodeEntry<K, E> next;

        public NodeEntry(K key, E value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        public NodeEntry<K, E> getNext() {
            return next;
        }

        @Override
        public E getValue() {
            return value;
        }

        @Override
        public K getKey() {
            return key;
        }
    }

    private NodeEntry<K, E> head;
    private NodeEntry<K, E> tail;
    private int n;

    public SortedLinkedPriorityQueue() {
        head = null;
        tail = null;
        n = 0;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public void insert(K k, E e) {
        NodeEntry<K, E> newNode = new NodeEntry<>(k, e);
        if (isEmpty()) {
            head = tail = newNode;
            n++;
            return;
        }
        if (head.getKey().compareTo(k) > 0) {
            newNode.next = head;
            head = newNode;
            n++;
            return;
        }
        NodeEntry<K, E> current = head;
        while (current.next != null && current.next.getKey().compareTo(k) <= 0) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        if (current == tail) {
            tail = newNode;
        }
        n++;
    }


    @Override
    public void insert(Entry<K, E> entry) {
        insert(entry.getKey(), entry.getValue());
    }

    @Override
    public Entry<K, E> removeMin() {
        if (isEmpty()) return null;
        NodeEntry<K, E> min = head;
        head = head.next;
        n--;
        return min;
    }

    @Override
    public Entry<K, E> min() {
        if (isEmpty()) return null;
        return head;
    }
}
