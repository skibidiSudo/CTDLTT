package Hw5_23001908_VuQuangNam.ex1;

public interface PriorityQueueInterface<K, E> {
    int size();

    boolean isEmpty();

    void insert(Entry<K, E> entry);

    void insert(K k, E e);

    Entry<K, E> removeMin();

    Entry<K, E> min();

    String getName();
}
