package Hw2_23001908_VuQuangNam.Ex10;

class Node {
    int value;
    Node next;
    Node(int value) {
        this.value = value;
    }
}

class Solution {
    Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
