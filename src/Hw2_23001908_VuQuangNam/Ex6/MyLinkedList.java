package Hw2_23001908_VuQuangNam.Ex6;

class ListNode {
    int val;
    ListNode next;
    ListNode prev;

    public ListNode (int val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

class MyLinkedList {
    private ListNode left;
    private ListNode right;

    public MyLinkedList() {
        this.left = new ListNode(0);
        this.right = new ListNode(0);
        left.next = right;
        right.prev = left;
    }

    public int get(int index) {
        ListNode curr = left.next;
        while (curr != null && index > 0) {
            index--;
            curr = curr.next;
        }
        if (curr != null && curr != right && index == 0) {
            return curr.val;
        }
        return -1;
    }

    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        ListNode next = left.next;
        ListNode prev = left;
        next.prev = newNode;
        prev.next = newNode;
        newNode.next = next;
        newNode.prev = prev;
    }

    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);
        ListNode next = right;
        ListNode prev = right.prev;
        next.prev = newNode;
        prev.next = newNode;
        newNode.next = next;
        newNode.prev = prev;
    }

    public void addAtIndex(int index, int val) {
        ListNode curr = left.next;
        while (curr != null && index > 0) {
            index--;
            curr = curr.next;
        }
        if (curr != null && index == 0) {
            ListNode newNode = new ListNode(val);
            ListNode next = curr;
            ListNode prev = curr.prev;
            next.prev = newNode;
            prev.next = newNode;
            newNode.next = next;
            newNode.prev = prev;
        }
    }

    public void deleteAtIndex(int index) {
        ListNode curr = left.next;
        while (curr != null && index > 0) {
            index--;
            curr = curr.next;
        }
        if (curr != null && curr != right && index == 0) {
            ListNode next = curr.next;
            ListNode prev = curr.prev;
            next.prev = prev;
            prev.next = next;
        }
    }
}
