package Hw6_23001908_VuQuangNam.ex12345;

import java.util.*;

public class GraphAlgorithms<V> {
    private static GraphDW<Integer> graph;
    private static List<Vertex<Integer>> vertices;
    private static List<Edge<Integer>> edges;
    private static Map<Integer, List<int[]>> adj;
    //Danh sach ke, moi dinh gan voi 1 List, 1 phan tu cua List la 1 mang co 2, a[0] = dinh ke, a[1] = trong so

    public static void main(String[] args) {
        Random random = new Random();
        int index = random.nextInt(6);
        initGraph();
        initAdj();
        //dfs();
        //bfs();
        //Vertex<Integer>[] vertex = graph.endVertices(edges.get(index));
        //dijkstra(vertex[0], vertex[1]);
        //dijkstra(vertices.get(0), vertices.get(5));
        //hamiltonPath();
        //hamiltonCycle();
        //eulerTrail();
        //eulerTour(vertices.get(0));
        //spanningTree();
        //coloringGraph();
        chromaticNumber();
    }

    private static void initGraph() {
        graph = new GraphDW<>();
        //add Vertex
        Vertex<Integer> v1 = graph.insertVertex(1);
        Vertex<Integer> v2 = graph.insertVertex(2);
        Vertex<Integer> v3 = graph.insertVertex(3);
        Vertex<Integer> v4 = graph.insertVertex(4);
        Vertex<Integer> v5 = graph.insertVertex(5);
        Vertex<Integer> v6 = graph.insertVertex(6);
        //Vertex<Integer> v7 = graph.insertVertex(7);

        //add Edge
        graph.insertEdge(v1, v2, 5, false);
        graph.insertEdge(v1, v3, 1, false);
        graph.insertEdge(v1, v5, 6, false);
        graph.insertEdge(v1, v4, 8, false);
        graph.insertEdge(v2, v3, 9, false);
        graph.insertEdge(v3, v5, 19, false);
        graph.insertEdge(v3, v6, 11, false);
        graph.insertEdge(v5, v6, 2, false);
        graph.insertEdge(v4, v5, 7, false);

        /*Graph is in 2 parts
        Vertex<Integer> v1 = graph.insertVertex(1);
        Vertex<Integer> v2 = graph.insertVertex(2);
        Vertex<Integer> v3 = graph.insertVertex(3);
        Vertex<Integer> v4 = graph.insertVertex(4);
        Vertex<Integer> v5 = graph.insertVertex(5);
        Vertex<Integer> v6 = graph.insertVertex(6);
        Vertex<Integer> v7 = graph.insertVertex(7);
        Vertex<Integer> v8 = graph.insertVertex(8);
        Vertex<Integer> v9 = graph.insertVertex(9);
        Vertex<Integer> v10 = graph.insertVertex(10);
        Vertex<Integer> v11 = graph.insertVertex(11);
        Vertex<Integer> v12 = graph.insertVertex(12);

        graph.insertEdge(v1, v6, 3, false);
        graph.insertEdge(v1, v8, 4, false);
        graph.insertEdge(v1, v10, 7, false);
        graph.insertEdge(v2, v7, 6, false);
        graph.insertEdge(v2, v9, 2, false);
        graph.insertEdge(v3, v7, 5, false);
        graph.insertEdge(v3, v10, 8, false);
        graph.insertEdge(v4, v6, 1, false);
        graph.insertEdge(v4, v11, 9, false);
        graph.insertEdge(v5, v8, 4, false);
        graph.insertEdge(v5, v12, 6, false);
        graph.insertEdge(v3, v12, 10, false); */


        vertices = graph.getVertices();
        edges = graph.getEdges();
    }

    private static void initAdj() {
        adj = new HashMap<>();
        for (int i = 1; i <= vertices.size(); i++) {
            adj.putIfAbsent(i, new ArrayList<>());
        }
        for (int i = 0; i < edges.size(); i++) {
            Edge<Integer> edge = edges.get(i);
            Vertex<Integer> u = edge.getU(), v = edge.getV();
            int w = edge.getWeight();
            adj.get(u.getElement()).add(new int[]{v.getElement(), w});
            adj.get(v.getElement()).add(new int[]{u.getElement(), w});
        }
    }

    private static void dfs() {
        System.out.println("dfs: ");
        List<List<Integer>> dfsList = new ArrayList<>();
        boolean[] visited = new boolean[vertices.size() + 1];
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= vertices.size(); i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                stack.push(i);
                while (!stack.isEmpty()) {
                    int vertex = stack.pop();
                    if (!visited[vertex]) {
                        visited[vertex] = true;
                        component.add(vertex);
                    }
                    List<int[]> adjVertex = adj.get(vertex);
                    for (int j = 0; j < adjVertex.size(); j++) {
                        int neighbor = adjVertex.get(j)[0];
                        if (!visited[neighbor]) {
                            stack.push(neighbor);
                        }
                    }
                }
                dfsList.add(component);
            }
        }
        for (List<Integer> component : dfsList) {
            printList(component, false);
            System.out.println();
        }
    }


    private static void bfs() {
        System.out.println("bfs: ");
        List<List<Integer>> bfsList = new ArrayList<>();
        boolean[] visited = new boolean[vertices.size() + 1];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= vertices.size(); i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                queue.add(i);
                while (!queue.isEmpty()) {
                    int vertex = queue.poll();
                    if (!visited[vertex]) {
                        visited[vertex] = true;
                        component.add(vertex);
                    }
                    List<int[]> adjVertex = adj.get(vertex);
                    for (int j = 0; j < adjVertex.size(); j++) {
                        int neighbor = adjVertex.get(j)[0];
                        if (!visited[neighbor]) {
                            queue.add(neighbor);
                        }
                    }
                }
                bfsList.add(component);
            }
        }
        for (List<Integer> component : bfsList) {
            printList(component, false);
            System.out.println();
        }
    }

    private static void dijkstra(Vertex<Integer> u, Vertex<Integer> v) {
        int[] distance = new int[vertices.size() + 1];
        boolean[] visited = new boolean[vertices.size() + 1];
        int[] previous = new int[vertices.size() + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(previous, -1);
        distance[u.getElement()] = 0;
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        minHeap.add(new int[]{u.getElement(), 0});
        while (!minHeap.isEmpty()) {
            int[] element = minHeap.poll();
            int vertexU = element[0], wU = element[1];
            if (visited[vertexU]) continue;
            visited[vertexU] = true;
            List<int[]> adjVertex = adj.get(vertexU);
            for (int[] e : adjVertex) {
                int vertexV = e[0], wV = e[1];
                if (!visited[vertexV] && distance[vertexV] > distance[vertexU] + wV) {
                    distance[vertexV] = distance[vertexU] + wV;
                    previous[vertexV] = vertexU;
                    minHeap.add(new int[]{vertexV, distance[vertexV]});
                }
            }
            if (vertexU == v.getElement()) {
                break;
            }
        }
        if (distance[v.getElement()] == Integer.MAX_VALUE) {
            System.out.println("No path between " + u.getElement() + " and " + v.getElement());
        } else {
            List<Integer> path = new ArrayList<>();
            for (int at = v.getElement(); at != -1; at = previous[at]) {
                path.add(at);
            }
            Collections.reverse(path);
            System.out.println("Path between " + u.getElement() + "-" + v.getElement() + ": ");
            printList(path, true);
            System.out.println("Distance: " + distance[v.getElement()]);
        }
    }

    private static void hamiltonPath() {
        int numVertex = vertices.size();
        int[][] adjMatrix = new int[numVertex + 1][numVertex + 1];
        for (Map.Entry<Integer, List<int[]>> entry : adj.entrySet()) {
            int u = entry.getKey();
            for (int[] element : entry.getValue()) {
                int v = element[0];
                adjMatrix[u][v] = 1;
                adjMatrix[v][u] = 1;
            }
        }
        boolean[] visited = new boolean[numVertex + 1];
        List<Integer> hamiltonPath = new ArrayList<>();
        for (int i = 1; i <= numVertex; i++) {
            hamiltonPath.clear();
            if (backtrack(1, visited, adjMatrix, i, numVertex, hamiltonPath, false)) {
                System.out.println("Hamilton path: ");
                printList(hamiltonPath, true);
                return;
            }
        }
        System.out.println("Not found hamilton path.");
    }

    private static boolean backtrack(int count, boolean[] visited, int[][] adjMatrix, int i, int numVertex, List<Integer> path, boolean findCycle) {
        path.add(i);
        visited[i] = true;
        if (count == numVertex) {
            if (findCycle) {
                if (adjMatrix[i][path.get(0)] == 1) {
                    path.add(path.get(0));
                    return true;
                }
                return false;
            }
            return true;
        }
        for (int nei = 1; nei <= numVertex; nei++) {
            if (adjMatrix[i][nei] == 1 && !visited[nei]) {
                if (backtrack(count + 1, visited, adjMatrix, nei, numVertex, path, findCycle)) {
                    return true;
                }
            }
        }
        visited[i] = false;
        path.remove(path.size() - 1);
        return false;
    }

    private static void hamiltonCycle() {
        int numVertex = vertices.size();
        int[][] adjMatrix = new int[numVertex + 1][numVertex + 1];
        for (Map.Entry<Integer, List<int[]>> entry : adj.entrySet()) {
            int u = entry.getKey();
            for (int[] element : entry.getValue()) {
                int v = element[0];
                adjMatrix[u][v] = 1;
                adjMatrix[v][u] = 1;
            }
        }
        boolean[] visited = new boolean[numVertex + 1];
        List<Integer> hamiltonCycle = new ArrayList<>();
        for (int i = 1; i <= numVertex; i++) {
            hamiltonCycle.clear();
            if (backtrack(1, visited, adjMatrix, i, numVertex, hamiltonCycle, true)) {
                System.out.println("Hamiltonian cycle: ");
                printList(hamiltonCycle, true);
                return;
            }
        }
        System.out.println("Not found Hamiltonian cycle.");
    }


    private static void eulerTrail() {
        int count = 0;
        int startVertex = -1;
        for (Map.Entry<Integer, List<int[]>> entry : adj.entrySet()) {
            if (entry.getValue().size() % 2 == 1) {
                count++;
                startVertex = entry.getKey();
            }
        }
        if (count != 0) {
            if (count != 2) {
                System.out.println("Not found Euler trail.");
                return;
            }
        }
        eulerTour(new Vertex<>(startVertex));
    }


    private static void eulerTour(Vertex<Integer> start) {
        Vertex<Integer> vertex = (start.getElement() == -1) ? vertices.get(0) : start;
        Map<Integer, List<Integer>> adjClone = new HashMap<>();
        for (Map.Entry<Integer, List<int[]>> entry : adj.entrySet()) {
            int key = entry.getKey();
            List<int[]> value = entry.getValue();
            List<Integer> newList = new ArrayList<>();
            for (int[] element : value) {
                newList.add(element[0]);
            }
            adjClone.put(key, newList);
        }
        for (Map.Entry<Integer, List<Integer>> entry : adjClone.entrySet()) {
            if (entry.getValue().size() % 2 == 1) {
                System.out.println("Not found Euler tour.");
                return;
            }
        }
        List<Integer> euler = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(vertex.getElement());
        while (!stack.isEmpty()) {
            int x = stack.peek();
            List<Integer> neighbors = adjClone.get(x);
            if (!neighbors.isEmpty()) {
                int y = neighbors.get(0);
                stack.push(y);
                adjClone.get(x).remove((Integer) y);
                adjClone.get(y).remove((Integer) x);
            } else {
                euler.add(x);
                stack.pop();
            }
        }
        System.out.println(((graph.inDegree(start) + graph.outDegree(start)) % 2 == 1 || (start.getElement() == -1)) ? "Euler trail: " : "Euler tour: ");
        printList(euler, true);
    }

    private static void spanningTree() {
        List<Edge<Integer>> minimumSpanningTree = new ArrayList<>();
        List<Edge<Integer>> edgesList = edges;
        Collections.sort(edgesList, (a, b) -> a.getWeight() - b.getWeight());
        int spanningTreeWeight = 0;
        UnionFind unionFind = new UnionFind(vertices.size() + 1);
        int numEdge = vertices.size() - 1;
        while (minimumSpanningTree.size() < numEdge && !edgesList.isEmpty()) {
            for (Edge<Integer> edge : edgesList) {
                Vertex<Integer>[] ver = graph.endVertices(edge);
                int u = ver[0].getElement(), v = ver[1].getElement();
                if (unionFind.find(u) != unionFind.find(v)) {
                    minimumSpanningTree.add(edge);
                    spanningTreeWeight += edge.getWeight();
                    unionFind.union(u, v);
                    numEdge--;
                }

                if (numEdge == 0) {
                    break;
                }
            }
        }
        if (numEdge != 0) {
            System.out.println("Not found spanning tree.");
            return;
        }
        System.out.println("Minimum spanning tree: ");
        for (Edge<Integer> edge : minimumSpanningTree) {
            System.out.print(edge.toString() + " ");
        }
        System.out.println("\nTotal weight of spanning tree: " + spanningTreeWeight);
    }

    private static void coloringGraph() {
        boolean check = true;
        int numVertex = vertices.size();
        int[] coloring = new int[numVertex + 1];
        for (int i = 1; i <= numVertex; i++) {
            if (coloring[i] == 0) {
                if (!(bfsCheck(i, coloring))) {
                    check = false;
                }
            }
        }
        if (check) {
            System.out.println("The graph is in 2 parts.");
        } else {
            System.out.println("The graph is not in 2 parts.");
        }
    }

    private static boolean bfsCheck(int u, int[] coloring) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(u);
        coloring[u] = 1;
        while (!queue.isEmpty()) {
            int v = queue.poll();
            int currentColor = coloring[v];
            int nextColor = -currentColor;
            List<int[]> adjList = adj.get(v);
            for (int[] element : adjList) {
                if (coloring[element[0]] == 0) {
                    queue.add(element[0]);
                    coloring[element[0]] = nextColor;
                } else {
                    if (coloring[element[0]] == currentColor) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static void chromaticNumber() {
        int[] color = new int[vertices.size() + 1];
        Arrays.fill(color, -1);
        color[1] = 0;
        boolean[] availableColors = new boolean[vertices.size()];
        Arrays.fill(availableColors, true);
        for (int i = 2; i <= vertices.size(); i++) {
            List<int[]> adjVertices = adj.get(i);
            for (int[] neighbor : adjVertices) {
                int neighborVertex = neighbor[0];
                if (color[neighborVertex] != -1) {
                    availableColors[color[neighborVertex]] = false;
                }
            }
            int chosenColor;
            for (chosenColor = 0; chosenColor < availableColors.length; chosenColor++) {
                if (availableColors[chosenColor]) {
                    break;
                }
            }
            color[i] = chosenColor;
            Arrays.fill(availableColors, true);
        }
        int chromaticNumber = 0;
        for (int i = 1; i <= vertices.size(); i++) {
            chromaticNumber = Math.max(chromaticNumber, color[i]);
        }
        System.out.println("Chromatic number of the graph is: " + ++chromaticNumber);
    }


    private static void printList(List<Integer> list, boolean flag) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                System.out.print(list.get(i));
            } else {
                System.out.print(list.get(i) + (flag ? " -> " : " "));
            }
        }
        System.out.println();
    }
}
