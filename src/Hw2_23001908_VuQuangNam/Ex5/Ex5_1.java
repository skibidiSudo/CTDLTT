package Hw2_23001908_VuQuangNam.Ex5;

import java.util.Scanner;

public class Ex5_1 {
    public static Node createNode(int x) {
        return new Node(x);
    }

    public static Node addElement(Node p, int x) {
        Node temp = createNode(x);
        p.next = temp;
        return temp;
    }

    public static void printList(Node l) {
        Node p = l;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
        }
        int k = sc.nextInt(), x = sc.nextInt();

        Node l = createNode(data[0]);
        Node p = l;
        for (int i = 1; i < n; i++) {
            p = addElement(p, data[i]);
        }

        Node nodeX = createNode(x);
        Node head = l;

        if (k == 0) {
            nodeX.next = head;
            l = nodeX;
        } else {
            while (head.next != null && k > 1) {
                head = head.next;
                k--;
            }
            Node temp = head.next;
            head.next = nodeX;
            nodeX.next = temp;
        }

        printList(l);

        sc.close();
    }
}
