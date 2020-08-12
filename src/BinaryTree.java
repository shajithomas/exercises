import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    @Test
    public void testCreate_empty() {
        long[] treeData = {};
        Node tree = createTree(treeData);
        System.out.println(tree);
    }
    @Test
    public void testCreate_normal() {
//        long[] treeData = {10,8,14,7,9,12,15,6};
        long[] treeData = {1,10,5,1,0,6,12};
        Node tree = createTree(treeData);
        System.out.println(tree);
    }

    public Node createTree(long[] data) {
        if (data == null || data.length == 0) {
            return  null;
        }
        Queue<Node> q = new LinkedList<>();
        Node root = new Node(data[0]);
        q.offer(root);
        int i = 1;
        while (i < data.length && !q.isEmpty()) {
           Node current = q.poll();
           current.left = new Node(data[i]);
           q.offer(current.left);
           if ((i+1) >= data.length ) {
               break;
           }
           current.right = new Node(data[i+1]);
           q.offer(current.right);
           i += 2;
        }
        return root;
    }

    class Node {
        long val;
        Node left = null;
        Node right = null;
        Node(long val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "\nNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
