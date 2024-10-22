package Hw4_23001908_VuQuangNam.Bonus.ex5;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val,TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    int value;
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        value = root.val;
        return search(root);
    }

    private boolean search(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (value != root.val) {
            return false;
        }
        return search(root.left) && search(root.right);
    }
}
