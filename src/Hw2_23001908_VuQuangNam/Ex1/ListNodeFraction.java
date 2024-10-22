package Hw2_23001908_VuQuangNam.Ex1;


public class ListNodeFraction implements MyIterable{
    private Node head;
    private int size;

    public ListNodeFraction() {
        head = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void add(Node node) {
        if (size == 0) {
            head = node;
            size++;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = node;
        size++;
    }

    public void remove(int index) {
        if (checkOutOfRange(index)) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (index == 0) {
            head = head.next;
            size--;
            return;
        }
        if (index == size - 1) {
            Node current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
            size--;
            return;
        }
        Node node = head;
        while (index-- > 1) {
            node = node.next;
        }
        node.next = node.next.next;
        size--;
    }

    public Fraction getFractionAtIndex(int index) {
        if (checkOutOfRange(index)) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Node node = head;
        while (index-- > 0) {
            node = node.next;
        }
        return node.fraction;
    }

    public boolean checkOutOfRange(int index) {
        return 0 > index || index >= size;
    }

    @Override
    public MyIterator iterator() {
        return new NodeIterator(head);
    }

    private class NodeIterator implements MyIterator {
        private Node current;

        public NodeIterator(Node head) {
            current = head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Fraction next() {
            if (hasNext()) {
                Node node = current;
                current = current.next;
                return node.fraction;
            }
            return null;
        }
    }
}
