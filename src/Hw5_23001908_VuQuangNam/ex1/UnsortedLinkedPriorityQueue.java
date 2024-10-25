package Hw5_23001908_VuQuangNam.ex1;

public class UnsortedLinkedPriorityQueue<K extends Comparable<K>, E> implements PriorityQueueInterface<K, E> {

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
        public String toString() {
            return "[" + key + ", " + value + "]";
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

    public UnsortedLinkedPriorityQueue() {
        head = null;
        tail = null;
        n = 0;
    }

    @Override
    public String getName() {
        return "UnsortedLinkedPriorityQueue";
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
    public void insert(K k, E e) {
        NodeEntry<K, E> node = new NodeEntry<>(k, e);
        if (isEmpty()) {
            head = tail = node;
            n++;
            return;
        }
        tail.next = node;
        tail = node;
        n++;
    }

    @Override
    public void insert(Entry<K, E> entry) {
        insert(entry.getKey(), entry.getValue());
    }

    @Override
    public Entry<K, E> min() {
        if (isEmpty()) return null;
        NodeEntry<K, E> min = head;
        NodeEntry<K, E> node = head;
        while (node != null) {
            if (min.getKey().compareTo(node.getKey()) > 0) {
                min = node;
            }
            node = node.next;
        }
        return min;
    }

    @Override
    public Entry<K, E> removeMin() {
        if (isEmpty()) return null;
        NodeEntry<K, E> min = head;
        NodeEntry<K, E> node = head;
        NodeEntry<K, E> prev = null;
        NodeEntry<K, E> prevMin = null;

        while (node != null) {
            if (min.getKey().compareTo(node.getKey()) > 0) {
                min = node;
                prevMin = prev;
            }
            prev = node;
            node = node.next;
        }
        if (min == head) {
            head = head.next;
        } else {
            prevMin.next = min.next;
        }
        if (min == tail) {
            tail = prevMin;
        }
        n--;
        return min;
    }
}
