package Hw2_23001908_VuQuangNam.Ex13;

class Node {
    int coeff;
    int pow;
    Node next;

    Node(int a, int b) {
        coeff = a;
        pow = b;
        next = null;
    }
}

class Solution {
    public static Node addPolynomial(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        if (head1.pow > head2.pow) {
            Node temp = addPolynomial(head1.next, head2);
            head1.next = temp;
            return head1;
        }
        if (head1.pow < head2.pow) {
            Node temp = addPolynomial(head1, head2.next);
            head2.next = temp;
            return head2;
        }
        Node temp = addPolynomial(head1.next, head2.next);
        head2.coeff += head1.coeff;
        head2.next = temp;
        return head2;
    }
}
