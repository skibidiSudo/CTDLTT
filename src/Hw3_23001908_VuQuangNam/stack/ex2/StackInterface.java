package Hw3_23001908_VuQuangNam.stack.ex2;

public interface StackInterface <E> extends Iterable<E> {
    void push(E element);
    E pop();
    boolean isEmpty();
    E top();
}
