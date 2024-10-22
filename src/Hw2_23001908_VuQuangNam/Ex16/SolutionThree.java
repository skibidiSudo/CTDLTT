package Hw2_23001908_VuQuangNam.Ex16;

class SolutionThree {
    public Node sortedInsert(Node head, int data) {
        /*if (head == null) {
            return new Node(data);
        }

        Node newNode = new Node(data);
        if (head.data >= data) {
            newNode.next = head;
            return newNode;
        }
        Node node = head;
        while (node.next != null && node.next.data < data) {
            node = node.next;
        }
        newNode.next = node.next;
        node.next = newNode;
        return head;*/
        Node newNode = new Node(data);
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }
        Node curr = head;
        Node nextToCurr = head.next;
        if (data <= head.data) {
            Node lastNode = head;
            while (lastNode.next != head) {
                lastNode = lastNode.next;
            }
            newNode.next = head;
            lastNode.next = newNode;
            return newNode;
        }
        while (curr.next != head) {
            if (curr.data < data && nextToCurr.data >= data) {
                newNode.next = curr.next;
                curr.next = newNode;
                return head;
            } else {
                curr = curr.next;
                nextToCurr = nextToCurr.next;
            }
        }
        newNode.next = head;
        curr.next = newNode;
        return head;
        // code here
    }
}
