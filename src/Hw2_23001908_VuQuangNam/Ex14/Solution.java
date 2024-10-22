package Hw2_23001908_VuQuangNam.Ex14;

class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        next = prev = null;
    }
}

class Solution {
    Node addNode(Node head, int p, int x) {
        Node newNode = new Node(x);
        if (head == null) {
            if (p == 0) {
                return newNode;
            } else {
                return null;
            }
        }
        if (p == 0) {
            newNode.next = head;
            head.prev = newNode;
            return newNode;
        }
        Node current = head;
        int count = 0;
        while (current != null && count < p) {
            current = current.next;
            count++;
        }
        if (current == null) {
            return head;
        }
        newNode.next = current.next;
        newNode.prev = current;
        if (current.next != null) {
            current.next.prev = newNode;
        }
        current.next = newNode;
        return head;
    }
}
