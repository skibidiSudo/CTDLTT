package Hw2_23001908_VuQuangNam.Ex14;

class SolutionTwo {
    public Node deleteNode(Node head, int x) {
        if (head == null) {
            return null;
        }
        if (x == 1) {
            Node newHead = head.next;
            if (newHead != null) {
                newHead.prev = null;
            }
            head.next = null;
            head.prev = null;

            return newHead;
        }
        Node current = head;
        int count = 1;
        while (current != null && count < x) {
            current = current.next;
            count++;
        }
        if (current == null) {
            return head;
        }
        if (current.prev != null) {
            current.prev.next = current.next;
        }

        if (current.next != null) {
            current.next.prev = current.prev;
        }
        current.next = null;
        current.prev = null;
        return head;
    }
}
