/*
 * simple graph traversal DFS
 * using pre-sized array to store the vertices.
 * uses a boolean array to store visited flag
 */
import java.util.ArrayList;
import java.util.LinkedList;

class Graph1 {
    private ArrayList<LinkedList<Integer>> graphArray;
    private boolean[] visited;

    Graph1(int v) {
        graphArray = new ArrayList<>(5);
        for (int i=0; i < v; i++) {
            graphArray.add(new LinkedList<Integer>());
        }
        visited = new boolean[v];
    }

    public void addEdge(int v1, int v2) {
        graphArray.get(v1).add(v2);
    }

    public void printGraph() {
        for (int i = 0; i < graphArray.size(); i++) {
            LinkedList<Integer> vertex = graphArray.get(i);
            int curVertex = i;
            vertex.forEach(v -> System.out.print(curVertex + " -> " + v + ", "));
            System.out.println();
        }
    }

    public void traverse(int vertex) {
        if (visited[vertex]) {
            return;
        }
        visited[vertex] = true;
        processNode(vertex);
        LinkedList<Integer> vertices = graphArray.get(vertex);
        for (Integer v : vertices) {
            if ( !visited[v]) {
                traverse(v);
            }
        }
    }
    public void processNode(int vertex) {
        System.out.println("processing Node: " + vertex);
    }

    public static void main(String[] args) {
        Graph1 g = new Graph1(4);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(2,0);
        g.addEdge(2,3);
        g.addEdge(3,3);
        g.printGraph();
        System.out.println("\n---------------------\n");

        g.traverse(2);

    }
}
