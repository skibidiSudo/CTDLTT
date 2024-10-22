package Hw2_23001908_VuQuangNam.Ex14;

class SolutionThree {
    public Node sortedInsert(Node head, int x) {
        if (head == null) {
            return head;
        }
        Node newNode = new Node(x);
        if (x <= head.data) {
            newNode.next = head;
            head.prev = newNode;
            return newNode;
        }
        Node current = head;
        while (current.next != null && current.next.data < x) {
            current = current.next;
        }
        newNode.next = current.next;
        if (current.next != null) {
            current.next.prev = newNode;
        }
        current.next = newNode;
        newNode.prev = current;
        return head;
    }
}
