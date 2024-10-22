package Hw2_23001908_VuQuangNam.Ex16;

class Solution {
    boolean isCircular(Node head) {
        if (head == null) return true;
        Node temp = head;
        while (head != null && head.next != temp) {
            head = head.next;
        }
        if (head == null || head.next == null) {
            return false;
        }
        return true;
        // Your code here
    }
}
