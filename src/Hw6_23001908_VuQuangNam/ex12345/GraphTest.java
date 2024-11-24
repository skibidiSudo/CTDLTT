package Hw6_23001908_VuQuangNam.ex12345;

public class GraphTest {
    public static void main(String[] args) {
        //testGraphUU();
        testGraphDW();
    }

    public static void testGraphUU() {
        GraphUU<String> graph = new GraphUU<>();

        // Insert vertices
        Vertex<String> v1 = graph.insertVertex("A");
        Vertex<String> v2 = graph.insertVertex("B");
        Vertex<String> v3 = graph.insertVertex("C");
        Vertex<String> v4 = graph.insertVertex("D");

        // Display all vertices
        System.out.println("Vertices:");
        for (Vertex<String> vertex : graph.vertices()) {
            System.out.println(vertex.getElement());
        }

        // Insert edges (undirected, weight is 0 by default)
        Edge<String> e1 = graph.insertEdge(v1, v2);
        Edge<String> e2 = graph.insertEdge(v2, v3);
        Edge<String> e3 = graph.insertEdge(v3, v4);
        Edge<String> e4 = graph.insertEdge(v4, v1);

        // Display all edges
        System.out.println("\nEdges:");
        for (Edge<String> edge : graph.getEdges()) {
            System.out.println(edge);
        }

        // Test numVertices() and numEdges()
        System.out.println("\nNumber of vertices: " + graph.numVertices());
        System.out.println("Number of edges: " + graph.numEdges());

        // Test getEdge()
        System.out.println("\nTesting getEdge:");
        Edge<String> edge = graph.getEdge(v1, v2);
        System.out.println("Edge between A and B: " + (edge != null ? edge : "Not found"));

        // Test endVertices() of an edge
        System.out.println("\nTesting endVertices:");
        Vertex<String>[] endVertices = graph.endVertices(e2);
        System.out.println("End vertices of edge e1: " + endVertices[0].getElement() + " - " + endVertices[1].getElement());

        // Test opposite()
        System.out.println("\nTesting opposite:");
        Vertex<String> opposite = graph.opposite(v1, e1);
        System.out.println("Opposite of A on edge e1: " + (opposite != null ? opposite.getElement() : "Not found"));

        // Test outDegree() and inDegree() (should be the same for undirected graph)
        System.out.println("\nTesting degrees:");
        System.out.println("Degree of A: " + graph.outDegree(v1));
        System.out.println("Degree of B: " + graph.inDegree(v2));

        // Test outgoingEdges() and incomingEdges() (should be the same for undirected graph)
        System.out.println("\nOutgoing edges from B:");
        for (Edge<String> outEdge : graph.outgoingEdges(v2)) {
            System.out.println(outEdge);
        }

        System.out.println("\nIncoming edges to B:");
        for (Edge<String> inEdge : graph.incomingEdges(v2)) {
            System.out.println(inEdge);
        }

        // Test removing an edge
        System.out.println("\nRemoving edge between A and B.");
        graph.removeEdge(e1);
        System.out.println("Edges after removal:");
        for (Edge<String> remainingEdge : graph.getEdges()) {
            System.out.println(remainingEdge);
        }
        System.out.println("Vertices after removal:");
        for (Vertex<String> remainingVertex : graph.vertices()) {
            System.out.println(remainingVertex.getElement());
        }

        // Test removing a vertex
        System.out.println("\nRemoving vertex C.");
        graph.removeVertex(v3);
        System.out.println("Vertices after removal:");
        for (Vertex<String> remainingVertex : graph.vertices()) {
            System.out.println(remainingVertex.getElement());
        }
        System.out.println("Edges after removal:");
        for (Edge<String> remainingEdge : graph.getEdges()) {
            System.out.println(remainingEdge);
        }

        // Final check of vertices and edges count
        System.out.println("\nFinal number of vertices: " + graph.numVertices());
        System.out.println("Final number of edges: " + graph.numEdges());
    }

    public static void testGraphDW() {
        // Initialize a directed weighted graph
        GraphDW<String> graph = new GraphDW<>();

        // Insert vertices
        Vertex<String> v1 = graph.insertVertex("A");
        Vertex<String> v2 = graph.insertVertex("B");
        Vertex<String> v3 = graph.insertVertex("C");
        Vertex<String> v4 = graph.insertVertex("D");
        Vertex<String> v5 = graph.insertVertex("E");
        Vertex<String> v6 = graph.insertVertex("F");
        Vertex<String> v7 = graph.insertVertex("G");
        Vertex<String> v8 = graph.insertVertex("H");

        // Display all vertices
        System.out.println("Vertices:");
        for (Vertex<String> vertex : graph.vertices()) {
            System.out.println(vertex.getElement());
        }

        // Insert edges (directional with weights)
        Edge<String> e1 = graph.insertEdge(v1, v2, 5, true);
        Edge<String> e2 = graph.insertEdge(v2, v3, 3, true);
        Edge<String> e3 = graph.insertEdge(v3, v4, 4, true);
        Edge<String> e4 = graph.insertEdge(v4, v1, 2, true);
        Edge<String> e5 = graph.insertEdge(v5, v6, 1, true);

        // Display all edges
        System.out.println("\nEdges:");
        for (Edge<String> edge : graph.getEdges()) {
            System.out.println(edge);
        }

        // Test numVertices() and numEdges()
        System.out.println("\nNumber of vertices: " + graph.numVertices());
        System.out.println("Number of edges: " + graph.numEdges());

        // Test getEdge()
        System.out.println("\nTesting getEdge:");
        Edge<String> edgeAB = graph.getEdge(v1, v2);
        System.out.println("Edge between A and B: " + (edgeAB != null ? edgeAB : "Not found"));

        // Test endVertices() of an edge
        System.out.println("\nTesting endVertices:");
        Vertex<String>[] endVertices = graph.endVertices(e2);
        System.out.println("End vertices of edge e2: " + endVertices[0].getElement() + " - " + endVertices[1].getElement());

        // Test opposite()
        System.out.println("\nTesting opposite:");
        Vertex<String> opposite = graph.opposite(v1, e1);
        System.out.println("Opposite of A on edge e1: " + (opposite != null ? opposite.getElement() : "Not found"));

        // Test outDegree() and inDegree()
        System.out.println("\nTesting degrees:");
        System.out.println("Out-degree of A: " + graph.outDegree(v1));
        System.out.println("In-degree of B: " + graph.inDegree(v2));

        // Test outgoingEdges() and incomingEdges()
        System.out.println("\nOutgoing edges from B:");
        for (Edge<String> outEdge : graph.outgoingEdges(v2)) {
            System.out.println(outEdge);
        }

        System.out.println("\nIncoming edges to B:");
        for (Edge<String> inEdge : graph.incomingEdges(v2)) {
            System.out.println(inEdge);
        }

        // Test removing an edge
        System.out.println("\nRemoving edge between A and B.");
        graph.removeEdge(e1);
        System.out.println("Edges after removal:");
        for (Edge<String> remainingEdge : graph.getEdges()) {
            System.out.println(remainingEdge);
        }

        // Test removing a vertex
        System.out.println("\nRemoving vertex C.");
        graph.removeVertex(v3);
        System.out.println("Vertices after removal:");
        for (Vertex<String> remainingVertex : graph.vertices()) {
            System.out.println(remainingVertex.getElement());
        }
        System.out.println("Edges after removal:");
        for (Edge<String> remainingEdge : graph.getEdges()) {
            System.out.println(remainingEdge);
        }

        // Final check of vertices and edges count
        System.out.println("\nFinal number of vertices: " + graph.numVertices());
        System.out.println("Final number of edges: " + graph.numEdges());
    }
}
