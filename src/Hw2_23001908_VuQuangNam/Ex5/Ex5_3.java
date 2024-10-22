package Hw2_23001908_VuQuangNam.Ex5;

import java.util.Scanner;

public class Ex5_3 {
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
        int k = sc.nextInt();

        Node l = createNode(data[0]);
        Node p = l;
        for (int i = 1; i < n; i++) {
            p = addElement(p, data[i]);
        }

        if (k == 0) {
            l = l.next;
        } else {
            Node head = l;
            while (head.next != null && k > 1) {
                head = head.next;
                k--;
            }
            if (head.next != null) {
                head.next = head.next.next;
            }
        }

        printList(l);

        sc.close();
    }
}
