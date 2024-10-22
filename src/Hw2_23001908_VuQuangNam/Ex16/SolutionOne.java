package Hw2_23001908_VuQuangNam.Ex16;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }

}

class SolutionOne {
    void printList(Node head) {
        Node current = head;
        System.out.print(current.data + " ");
        current = current.next;
        while (current != head) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}
