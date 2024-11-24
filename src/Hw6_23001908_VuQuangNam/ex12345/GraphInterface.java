package Hw6_23001908_VuQuangNam.ex12345;

public interface GraphInterface<V> {
    int numVertices(); //so luong dinh
    Iterable<Vertex<V>> vertices(); //duyet dinh
    int numEdges(); // so luong canh
    Edge<V> getEdge(Vertex<V> u, Vertex<V> v); // tra ve canh uv
    Vertex<V>[] endVertices(Edge<V> e); //tra ve 2 dinh cua canh e
    Vertex<V> opposite(Vertex<V> u, Edge<V> e); // tra ve dinh con lai cua canh e
    Vertex<V> insertVertex(V x); //tao va tra ve 1 dinh
    Edge<V> insertEdge(Vertex<V> u, Vertex<V> v, int w, boolean isDirectional); //tao va tra ve 1 canh uv voi trong so la x
    void removeVertex(Vertex<V> v); //xoa dinh v
    void removeEdge(Edge<V> e); //xoa canh e
    int outDegree(Vertex<V> v); //bac ra cua v
    int inDegree(Vertex<V> v); //bac vao cua v
    Iterable<Edge<V>> outgoingEdges(Vertex<V> v); // duyet canh ra
    Iterable<Edge<V>> incomingEdges(Vertex<V> v); //duyet canh vao
}
