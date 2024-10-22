package Hw2_23001908_VuQuangNam.Ex9;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}
// complete the below function
class Solution {
    public static int count(Node head, int key) {
        int count = 0;
        while (head != null) {
            if (head.data == key) {
                count++;
            }
            head = head.next;
        }
        return count;
        // code here
    }
}

