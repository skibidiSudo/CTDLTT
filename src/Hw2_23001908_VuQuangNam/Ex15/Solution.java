package Hw2_23001908_VuQuangNam.Ex15;

class Node{
    int data;
    Node next, prev;
    Node(int data){
        this.data = data;
        next = null;
        prev = null;
    }
}

class Solution{
    public Node rotateDLL(Node start, int p) {
        if (start == null || p == 0) {
            return start;
        }
        Node node = start;
        int count = 1;
        while (count++ < p && node != null) {
            node = node.next;
        }
        if (node == null || node.next == null) {
            return start;
        }
        Node pNode = node;
        Node newStart = pNode.next;
        if (newStart != null) {
            newStart.prev = null;
        }
        while (node.next != null) {
            node = node.next;
        }
        node.next = start;
        start.prev = node;
        pNode.next = null;
        return newStart;
    }
}
