package Hw4_23001908_VuQuangNam.Exercise.ex1;

public class Main {
    public static void main(String[] args) {
        //arrayBinaryTree();
        linkedListBinaryTree();
    }

    private static void arrayBinaryTree() {
        ArrayBinaryTree<Integer, Integer> arrayTree = new ArrayBinaryTree<>();
        arrayTree.setRoot(1);
        arrayTree.setLeft(1, 2);
        arrayTree.setRight(1, 3);
        arrayTree.setLeft(2, 4);
        arrayTree.setRight(2, 5);
        arrayTree.setLeft(3, 6);
        arrayTree.setRight(3, 7);

        System.out.println("Array Binary Tree:");
        arrayTree.printTree();
    }

    private static void linkedListBinaryTree() {
        LinkedBinaryTree<Integer, Integer> tree = new LinkedBinaryTree<>();
        LinkedBinaryTree.Node<Integer> rootNode = tree.addRoot(1);
        LinkedBinaryTree.Node<Integer> leftChild = tree.addLeft(rootNode, 2);
        LinkedBinaryTree.Node<Integer> rightChild = tree.addRight(rootNode, 3);

        tree.addLeft(leftChild, 4);
        tree.addRight(leftChild, 5);
        tree.addLeft(rightChild, 6);
        tree.addRight(rightChild, 7);
        tree.printTree();
    }
}
