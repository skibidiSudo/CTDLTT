package Hw6_23001908_VuQuangNam.ex12345;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GraphDW<V> implements GraphInterface<V>{
    // co huong co trong so
    private List<Vertex<V>> vertices;
    private List<Edge<V>> edges;

    public GraphDW() {
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
    }

    public List<Vertex<V>> getVertices() {
        return vertices;
    }

    public List<Edge<V>> getEdges() {
        return edges;
    }

    public GraphDW(List<Vertex<V>> vertices, List<Edge<V>> edges) {
        this.vertices = vertices;
        this.edges = edges;
    }

    @Override
    public Edge<V> getEdge(Vertex<V> u, Vertex<V> v) {
        for (Edge<V> edge : edges) {
            if (edge.equals(new Edge<>(u, v, 0, true))) {
                return edge;
            }
        }
        return null;
    }

    @Override
    public Vertex<V> insertVertex(V u) {
        Vertex<V> vertex = new Vertex<>(u);
        vertices.add(vertex);
        return vertex;
    }

    @Override
    public Edge<V> insertEdge(Vertex<V> u, Vertex<V> v, int w, boolean isDirectional) {
        Edge<V> edge = new Edge<>(u, v, w, isDirectional);
        edges.add(edge);
        return edge;
    }

    @Override
    public int inDegree(Vertex<V> v) {
        int count = 0;
        for (Edge<V> edge : edges) {
            if (edge.getV().equals(v)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int outDegree(Vertex<V> v) {
        int count = 0;
        for (Edge<V> edge : edges) {
            if (edge.getU().equals(v)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public void removeEdge(Edge<V> e) {
        edges.remove(e);
    }

    @Override
    public void removeVertex(Vertex<V> v) {
        vertices.remove(v);
        Iterator<Edge<V>> iterator = edges.iterator();
        while (iterator.hasNext()) {
            Edge<V> edge = iterator.next();
            if (edge.getV().equals(v) || edge.getU().equals(v)) {
                iterator.remove();
            }
        }
    }

    @Override
    public Vertex<V>[] endVertices(Edge<V> e) {
        for (Edge<V> edge : edges) {
            if (e.equals(edge)) {
                return new Vertex[]{edge.getU(), edge.getV()};
            }
        }
        return null;
    }

    @Override
    public Vertex<V> opposite(Vertex<V> u, Edge<V> e) {
        for (Edge<V> edge : edges) {
            if (e.equals(edge)) {
                if (edge.getV().equals(u)) {
                    return edge.getU();
                }
                return edge.getV();
            }
        }
        return null;
    }

    @Override
    public int numVertices() {
        return vertices.size();
    }

    @Override
    public int numEdges() {
        return edges.size();
    }

    @Override
    public Iterable<Vertex<V>> vertices() {
        return vertices;
    }

    @Override
    public Iterable<Edge<V>> incomingEdges(Vertex<V> v) {
        List<Edge<V>> incomingEdgesList = new ArrayList<>();
        for (Edge<V> edge : edges) {
            if (edge.getV().equals(v)) {
                incomingEdgesList.add(edge);
            }
        }
        return incomingEdgesList;
    }

    @Override
    public Iterable<Edge<V>> outgoingEdges(Vertex<V> v) {
        List<Edge<V>> outgoingEdgesList = new ArrayList<>();
        for (Edge<V> edge : edges) {
            if (edge.getU().equals(v)) {
                outgoingEdgesList.add(edge);
            }
        }
        return outgoingEdgesList;
    }
}
