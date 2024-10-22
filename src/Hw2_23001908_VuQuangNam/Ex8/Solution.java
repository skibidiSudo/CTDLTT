package Hw2_23001908_VuQuangNam.Ex8;

class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}

class Solution {

    // Function to find the data of kth node from
    // the end of a linked list.
    int getKthFromLast(Node head, int k) {
        Node node = head;
        int count = 0;
        while (node != null) {
            node = node.next;
            count++;
        }
        if (k > count) {
            return -1;
        }
        int num = (count - k);
        while (num-- > 0) {
            head = head.next;
        }
        return head.data;
        // Your code here
    }
}

