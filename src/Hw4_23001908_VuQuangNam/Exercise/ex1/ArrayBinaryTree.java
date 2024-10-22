
package Hw4_23001908_VuQuangNam.Exercise.ex1;

public class ArrayBinaryTree<E, T> implements BinaryTreeInterface<T> {
    private E[] array;
    private int n = 0;
    private int defaultSize = 100;

    public ArrayBinaryTree() {
        array = (E[]) new Object[defaultSize];
    }

    public void setRoot(E element) {
        array[1] = element;
        n++;
    }

    public void setLeft(int p, E element) {
        if (2 * p >= array.length) {
            enlarge();
        }
        array[2 * p] = element;
        n++;
    }

    public void setRight(int p, E element) {
        if (2 * p + 1 >= array.length) {
            enlarge();
        }
        array[2 * p + 1] = element;
        n++;
    }

    public void enlarge() {
        int size = array.length * 2;
        E[] newArray = (E[]) new Object[size];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    public int find(T node) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] != null && array[i].equals(node)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public T root() {
        return (T) array[1];
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public int numChildren(T p) {
        int index = find(p);
        if (index == -1) {
            return 0;
        }
        int count = 0;
        if (2 * index < array.length && array[2 * index] != null) {
            count++;
        }
        if (2 * index + 1 < array.length && array[2 * index + 1] != null) {
            count++;
        }
        return count;
    }

    @Override
    public T parent(T p) {
        int index = find(p);
        if (index <= 1) {
            return null;
        }
        return (T) array[index / 2];
    }

    @Override
    public T left(T p) {
        int index = find(p);
        if (index == -1) {
            return null;
        }
        return (T) array[2 * index];
    }

    @Override
    public T right(T p) {
        int index = find(p);
        if (index == -1) {
            return null;
        }
        return (T) array[2 * index + 1];
    }

    @Override
    public T sibling(T p) {
        int index = find(p);
        if (index == -1 || index == 1) {
            return null;
        }
        if (index % 2 == 0) {
            return (T) array[index - 1];
        }
        return (T) array[index + 1];
    }

    public void printTree() {
        printTree(1, 0);
    }

    private void printTree(int index, int depth) {
        if (index < array.length && array[index] != null) {
            printTree(2 * index + 1, depth + 1);
            for (int i = 0; i < depth; i++) {
                System.out.print("   ");
            }
            System.out.println(array[index]);
            printTree(2 * index, depth + 1);
        }
    }
}
