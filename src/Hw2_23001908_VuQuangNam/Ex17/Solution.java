package Hw2_23001908_VuQuangNam.Ex17;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class Pair {
    Node node1;
    Node node2;
    Pair(Node node1, Node node2) {
        this.node1 = node1;
        this.node2 = node2;
    }
}

public class Solution {
    public Pair splitList(Node head) {
        if (head == null) {
            return new Pair(null, null);
        }

        Node turtle = head;
        Node rabbit = head;
        while (rabbit.next != head && rabbit.next.next != head) {
            rabbit = rabbit.next.next;
            turtle = turtle.next;
        }

        if (rabbit.next.next == head) {
            rabbit = rabbit.next;
        }
        Node head2 = turtle.next;
        turtle.next = head;
        rabbit.next = head2;
        return new Pair(head, head2);
        // Code here
    }
}
