package Hw6_23001908_VuQuangNam.ex12345;

public class Vertex<V> {
    private V element;

    public Vertex(V element) {
        this.element = element;
    }

    public V getElement() {
        return this.element;
    }

    @Override
    public String toString() {
        return element + "";
    }
}

