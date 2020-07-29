/*
 * check if path exists from vertex A to vertex B
 * Uses DFS and recursion to find path
 * If a path is returned, it prints yes and No if not found.
 * Link to problem - https://www.geeksforgeeks.org/find-if-there-is-a-path-between-two-vertices-in-an-undirected-graph/?ref=leftbar-rightbar
 * Graph in the solution is
 * 1 -> 2 -> 3 -> 4, 1 -> 4
 *
 * pict representation
 *    1 -> 2
 *    |    |
 *    V    V
 *    4 <- 3
 */
import java.util.HashMap;
import java.util.LinkedList;

class GraphPath {
    private HashMap<Integer, LinkedList<Integer>> graph;
    private HashMap<Integer, Boolean> visited;
    private int numVeritces;
    boolean pathFound = false;

    GraphPath(int size) {
        this.numVeritces = size;
        graph = new HashMap<>(size);
        visited = new HashMap<>(size);
    }

    private void init() {
        for (int i = 1; i<= numVeritces; i++) {
            LinkedList<Integer> edgeList = new LinkedList<>();
            graph.put(i, edgeList);
        }

    }

    public void addEdge(int u, int v) {
        graph.get(u).add(v);
    }

    public String findPath(int u, int v) {
        if (pathFound) {
            return "Yes";
        }
        LinkedList<Integer> vertices = graph.get(u);
        visited.put(u,true);
        for (int i=0; i<vertices.size(); i++) {
            Integer vertex = vertices.get(i);
            if (visited.get(vertex) != null) {
                continue;
            }
            if (pathFound) {
                return "Yes";
            }
            visited.put(vertex, true);
            if (vertex == v) {
                pathFound = true;
                return "Yes";
            }
            findPath(vertex, v);

        }
        return "No";
    }
    public static void main(String[] args) {
        GraphPath graphPath = new GraphPath(4);
        graphPath.init();
        graphPath.addEdge(1,2);
        graphPath.addEdge(1,4);
        graphPath.addEdge(2,3);
        graphPath.addEdge(3,4);
        String result = graphPath.findPath(1,3);
        System.out.println(result);

    }
}
