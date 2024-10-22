package Hw4_23001908_VuQuangNam.Exercise.ex1;

public class LinkedBinaryTree<E, T> implements BinaryTreeInterface<T> {

    public static class Node<E> {
        private E element;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;

        // Constructs a node with the given element and neighbors.
        public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
            this.element = e;
            this.parent = above;
            this.left = leftChild;
            this.right = rightChild;
            // Todo: Initialize node with given parameters
        }

        public E getElement() {
            return element;
        }

        public Node<E> getParent() {
            return parent;
        }

        public Node<E> getLeft() {
            return left;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public void setParent(Node<E> parent) {
            this.parent = parent;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }
    }

    private Node<E> root;
    private int size;

    public LinkedBinaryTree() {
        root = null;
        size = 0;
    }

    // update methods
    public Node<E> addRoot(E element) {
        if (isEmpty()) {
            root = new Node<>(element, null, null, null);
            size++;
        }
        return root;
        // Add element to root of an empty tree
    }

    public Node<E> addLeft(Node<E> p, E element) {
        if (p.left == null) {
            p.left = new Node<>(element, p, null, null);
            size++;
            return p.left;
        }
        return null;
        // Add element to left child node of p if empty
    }

    public Node<E> addRight(Node<E> p, E element) {
        if (p.right == null) {
            p.right = new Node<>(element, p, null, null);
            size++;
            return p.right;
        }
        return null;
        // Add element to right child node of p if empty
    }

    public void set(Node<E> p, E element) {
        p.element = element;
        // Set element to node p
    }

    @Override
    public T root() {
        if (root != null) {
            return (T) root.element;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T parent(T p) {
        /*Node<E> node = findNode(p);
        if (node != null && node.parent != null) {
            return (T) node.parent.element;
        }*/
        if (p != null && ((Node<E>) p).parent != null) {
            return (T) ((Node<E>) p).parent;
        }
        return null;
    }

    @Override
    public T left(T p) {
        if (p != null && ((Node<E>) p).left != null) {
            return (T) ((Node<E>) p).left;
        }
        return null;
    }

    @Override
    public T right(T p) {
        if (p != null && ((Node<E>) p).right != null) {
            return (T) ((Node<E>) p).right;
        }
        return null;
    }

    @Override
    public T sibling(T p) {
        Node<E> node = findNode(p);
        if (node != null && node.parent != null) {
            if (node == node.parent.left) {
                return (T) node.parent.right.element;
            } else {
                return (T) node.parent.left.element;
            }
        }
        return null;
    }

    @Override
    public int numChildren(T p) {
        Node<E> node = findNode(p);
        int count = 0;
        if (node != null) {
            if (node.left != null) count++;
            if (node.right != null) count++;
        }
        return count;
    }

    private Node<E> findNode(T element) {
        return findNode(root, element);
    }

    private Node<E> findNode(Node<E> node, T element) {
        if (node == null) {
            return null;
        }
        if (node.element.equals(element)) {
            return node;
        }
        Node<E> leftResult = findNode(node.left, element);
        return (leftResult != null) ? leftResult : findNode(node.right, element);
    }

    public void printTree() {
        printTree(root, 0);
    }

    private void printTree(Node<E> node, int depth) {
        if (node != null) {
            printTree(node.right, depth + 1);
            for (int i = 0; i < depth; i++) {
                System.out.print("   ");
            }
            System.out.println(node.element);
            printTree(node.left, depth + 1);
        }
    }

}
