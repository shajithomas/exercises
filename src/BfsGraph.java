import org.junit.Test;

import java.util.*;

/*
 * BFS Graph traversal
 */
public class BfsGraph {

    //represents the vertex
    static class Node {
        int id;
        List<Node> adjacents;

        Node(int n) {
            this.id = n;
        }
    }
    private ArrayList<Node> graph;

    public BfsGraph(int n) {
        graph = new ArrayList<>(n);
        for (int i=0; i<n; i++) {
            Node node = new Node(i);
            node.adjacents = new LinkedList<>();
            graph.add(node);
        }
    }

    public void traverse(int id) {
        Node node = graph.get(id);
        Queue<Node> queue = new LinkedList<>();
        HashMap<Node, Boolean> marked = new HashMap<>();

        marked.put(node, true);
        queue.offer(node);

        while (!queue.isEmpty()) {
            Node vertex = queue.poll();
            visit(vertex);
            for (Node adjacent: vertex.adjacents) {
                if (marked.get(adjacent) == null ) {
                    marked.put(adjacent, true);
                    queue.offer(adjacent);
                }
            }
        }
    }

   /*
    * traverse2 - the only difference from traverse is
    * here the node is put into the Q before marking the node visited.
    * mark only when visiting.
    *
    * In traverse, its marked and put into the Q
    */
    public void traverse2(int id) {
        Node node = graph.get(id);
        Queue<Node> queue = new LinkedList<>();
        HashMap<Node, Boolean> marked = new HashMap<>();

        queue.offer(node);

        while (!queue.isEmpty()) {
            Node vertex = queue.poll();
            if (marked.get(vertex) == null) {
                marked.put(vertex, true);
                visit(vertex);
            }
            for (Node adjacent: vertex.adjacents) {
                if (marked.get(adjacent) == null ) {
                    queue.offer(adjacent);
                }
            }
        }
    }

    public void visit(Node n) {
        System.out.println(n.id);
    }

    public void addEdge(int n1, int n2) {
        Node node1 = graph.get(n1);
        Node node2 = graph.get(n2);
        node1.adjacents.add(node2);
    }

    /*
    Adjacency list used below is like this
    0|3
    1|2,4
    2|
    3|1
    4|2

    result for starting node 3: 3 1 2 4
    */
    public static void main(String[] args) {
        BfsGraph graph = new BfsGraph(5);
        graph.addEdge(0,3);
        graph.addEdge(1,2);
        graph.addEdge(1,4);
        graph.addEdge(3,1);
        graph.addEdge(4,2);

        graph.traverse(3);
        System.out.println("-------------");
        graph.traverse2(3);
    }

 }
