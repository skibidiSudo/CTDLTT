package Hw3_23001908_VuQuangNam.queue.ex1;

public interface QueueInterface<E> extends Iterable<E> {
    void enqueue(E element);
    E dequeue();
    boolean isEmpty();
}
