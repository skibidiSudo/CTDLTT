package Hw2_23001908_VuQuangNam.Ex11;

import java.util.Stack;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> val = new Stack<>();
        ListNode node = head;
        while (node != null) {
            val.add(node.val);
            node = node.next;
        }
        while (head != null && !val.isEmpty()) {
            if (head.val != val.pop()) {
                return false;
            }
            head = head.next;
        }
        if (!val.isEmpty() || head != null) {
            return false;
        }
        return true;
    }
}
