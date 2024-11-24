package Hw6_23001908_VuQuangNam.ex12345;

import java.util.ArrayList;
import java.util.List;

public class GraphUU<V> implements GraphInterface<V> {
    //vo huong khong trong so
    private List<Vertex<V>> vertices;
    private List<Edge<V>> edges;

    public GraphUU() {
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
    }

    public List<Vertex<V>> getVertices() {
        return vertices;
    }

    public List<Edge<V>> getEdges() {
        return edges;
    }

    public GraphUU(List<Vertex<V>> vertices, List<Edge<V>> edges) {
        this.vertices = vertices;
        this.edges = edges;
    }

    @Override
    public Edge<V> getEdge(Vertex<V> u, Vertex<V> v) {
        for (Edge<V> edge : edges) {
            if (edge.equals(new Edge<>(u, v, 0, false))) {
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

    public Edge<V> insertEdge(Vertex<V> u, Vertex<V> v) {
        return insertEdge(u, v, 0, false);
    }

    @Override
    public int inDegree(Vertex<V> v) {
        int count = 0;
        for (Edge<V> edge : edges) {
            if (edge.getV().equals(v) || edge.getU().equals(v)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int outDegree(Vertex<V> v) {
        return inDegree(v);
    }

    @Override
    public void removeEdge(Edge<V> e) {
        edges.remove(e);
    }

    @Override
    public void removeVertex(Vertex<V> v) {
        vertices.remove(v);
        List<Edge<V>> edgesToRemove = new ArrayList<>();
        for (Edge<V> edge : edges) {
            if (edge.getV().equals(v) || edge.getU().equals(v)) {
                edgesToRemove.add(edge);
            }
        }
        edges.removeAll(edgesToRemove);
    }


    @Override
    public Vertex<V>[] endVertices(Edge<V> e) {
        Vertex<V>[] ans = new Vertex[2];
        for (Edge<V> edge : edges) {
            if (e.equals(edge)) {
                ans[0] = edge.getU();
                ans[1] = edge.getV();
                return ans;
            }
        }
        return ans;
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
        return outgoingEdges(v);
    }

    @Override
    public Iterable<Edge<V>> outgoingEdges(Vertex<V> v) {
        List<Edge<V>> outgoingEdgesList = new ArrayList<>();
        for (Edge<V> edge : edges) {
            if (edge.getU().equals(v) || edge.getV().equals(v)) {
                outgoingEdgesList.add(edge);
            }
        }
        return outgoingEdgesList;
    }
}
