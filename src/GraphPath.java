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
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
        //create adjacency list for each vertex
        for (int i = 1; i<= numVeritces; i++) {
            LinkedList<Integer> edgeList = new LinkedList<>();
            graph.put(i, edgeList);
        }
    }

    //add edge from vertex u to vertex v
    public void addEdge(int u, int v) {
        graph.get(u).add(v);
    }

    public String findPath(int u, int v) {
        LinkedList<Integer> vertices = graph.get(u);
        visited.put(u,true);
        for (Integer vertex : vertices) {
          if (visited.get(vertex) == null)
            visited.put(vertex, true);
            if (vertex == v) {
                return "Yes";
            }
            return findPath(vertex, v);
        }
        return "No";
    }

/*
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
*/

    public static class UnitTest{
        GraphPath graph;

        @Before
        public void setup() {
            graph = new GraphPath(4);
            graph.init();
            graph.addEdge(1,2);
            graph.addEdge(1,4);
            graph.addEdge(2,3);
            graph.addEdge(3,4);
        }

        @Test
        public void testFindPath() {
            String result = graph.findPath(1,3);
            System.out.println(result);
            Assert.assertEquals("Yes", result);
        }

        @Test
        public void testFindPath_2() {
            String result = graph.findPath(2,4);
            System.out.println(result);
            Assert.assertEquals("Yes", result);
        }

        @Test
        public void testFindPath_3() {
            String result = graph.findPath(1,4);
            System.out.println(result);
            Assert.assertEquals("Yes", result);
        }

        @Test
        public void testFindPath2Negative() {
            String result = graph.findPath(4,2);
            System.out.println(result);
            Assert.assertEquals("No", result);
        }

    }
}
//todo: implement the vertex as an object

