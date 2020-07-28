/*
 * graph traversal using HashMap to store the Graph as adjacency list
 * A map of linkedLists 
 * uses a boolean HashMap to store visited flag
 */
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class Graph2 {
    private Map<Integer, LinkedList<Integer>> graph;
    private Map<Integer, Boolean> visited;

    Graph2(int v) {
        graph = new HashMap<>();
        visited = new HashMap<>();
    }

    public void addEdge(int v1, int v2) {
        LinkedList<Integer> v1List = graph.get(v1);
        LinkedList<Integer> v2List = graph.get(v2);
        if (v1List == null) {
            v1List = new LinkedList<>();
        }
        if (v2List == null) {
            v2List = new LinkedList<>();
        }
        v1List.add(v2);
        graph.put(v1, v1List);
        graph.put(v2, v2List);
    }

    public void printGraph() {
        for (int i = 0; i < graph.size(); i++) {
            LinkedList<Integer> vertex = graph.get(i);
            System.out.print("\nvertex " + i);
            vertex.forEach(v -> {
                System.out.print(" -> " + v);
            });
        }
    }

    public void traverse(int vertex) {
        if (visited.get(vertex) != null) {
            return;
        }
        visited.put(vertex,true);
        processNode(vertex);
        LinkedList<Integer> vertices = graph.get(vertex);
        for (Integer v : vertices) {
            if ( visited.get(v) == null) {
                traverse(v);
            }
        }
    }
    public void processNode(int vertex) {
        System.out.println("processing Node: " + vertex);
    }

    public static void main(String[] args) {
        Graph2 g = new Graph2(4);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(2,0);
        g.addEdge(2,3);
        g.addEdge(3,3);
        g.printGraph();
        System.out.println("\n---------------------\n");

        System.out.println("Verices from 2");

        g.traverse(2);

    }
}
