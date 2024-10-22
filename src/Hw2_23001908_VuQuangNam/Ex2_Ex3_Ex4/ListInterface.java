package Hw2_23001908_VuQuangNam.Ex2_Ex3_Ex4;

public interface ListInterface<T> extends Iterable<T> {
    void add(T data);
    T get(int i);
    void set(int i, T data);
    void remove(T data);
    boolean isContain(T data);
    int size();
    boolean isEmpty();
}
