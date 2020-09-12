import org.junit.Assert;
import org.junit.Test;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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

    @Test
    public void sorted_traversals() {
        // this is array representation of a sorted tree 1-10
        long[] treeData = {6,2,8,1,4,7,10,-1,-1,3,5,-1,-1,9};
        Node tree = createTree(treeData);
        System.out.println(tree);
        List<Long> ordered = new ArrayList<>();
        ordered = inOrder(tree, ordered);
        System.out.println("In order\n" + ordered);
        ordered.clear();
        ordered = reverseInOrder(tree, ordered);
        System.out.println("Reverse in order\n" + ordered);
    }

    /*
     * creates a binary tree from the array representation
     * uses BF traversal technique
     */
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
           if (current == null) {
               continue;
           }
           current.left = data[i] == -1 ? null : new Node(data[i]);
           q.offer(current.left);
           if ((i+1) >= data.length ) {
               break;
           }
           current.right = data[i+1] == -1 ? null : new Node(data[i+1]);
           q.offer(current.right);
           i += 2;
        }
        return root;
    }

    public List<Long> inOrder(Node root, List<Long> out) {
        if (root == null) {
            return null;
        }
        inOrder(root.left, out);
        out.add(root.val);
        inOrder(root.right, out);
        return out;
    }

    public List<Long> reverseInOrder(Node root, List<Long> out) {
        if (root == null) {
            return null;
        }
        reverseInOrder(root.right, out);
        out.add(root.val);
        reverseInOrder(root.left, out);
        return out;
    }

    public void printInOrder(Node root) {
        List<Long> out = new ArrayList<>();
        out = inOrder(root, out);
        System.out.println(out);
    }

    @Test
    public void testInvert() {
        long[] treeData = {6,2,8,1,4,7,10,-1,-1,3,5,-1,-1,9};
        Node tree = createTree(treeData);
        printInOrder(tree);
        tree = invert(tree);
        printInOrder(tree);

    }
    public Node invert(Node root) {
        if (root == null) {
            return null;
        }
        invert(root.left);
        invert(root.right);
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }


    @Test
    public void testLevelOrder() {
        // this is array representation of a sorted tree 1-10
        long[] treeData = {6,2,8,1,4,7,10,-1,-1,3,5,-1,-1,9};
        Node tree = createTree(treeData);
        System.out.println(tree);
        List result = levelOrder(tree);
        System.out.println(result);

        result = levelOrder2(tree);
        System.out.println(result);
    }


    /*
    * Each level is printed on a separate line
    */
    public List<List<Long>> levelOrder(Node root) {
        List<List<Long>> out = new ArrayList<>();
        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();
        List<Long> list = new ArrayList<>();

        /* pseudo code
        1. Add n to Q1
        2. create new List
        3. while Q1 not empty,
            a. loop:
                1. add n to list
                2. add n.left and n.right to Q2
            c. add list to out
            d. list = new List
            e. set Q1 = Q2
            d. Q2 = new Q
            repeat a through d
         */

        if (root!= null) {
            q1.add(root);
        }
        while (!q1.isEmpty()) {
            while (!q1.isEmpty()) {
                root = q1.poll();
                list.add(root.val);
                if (root.left != null) {
                    q2.offer(root.left);
                }
                if (root.right != null) {
                    q2.offer(root.right);
                }
            }
            out.add(list);
            list = new ArrayList<>();
            q1 = q2;
            q2 = new LinkedList<>();
        }
        return out;

    }

    /*
     * Each level is printed on a separate line
     */
    public List<List<Long>> levelOrder2(Node root) {
        List<List<Long>> out = new ArrayList<>();
        Queue<Node> q1 = new LinkedList<>();
        List<Long> list = new ArrayList<>();

        if (root!= null) {
            q1.add(root);
        }
        while (!q1.isEmpty()) {
            int levelSize = q1.size();
            while (levelSize > 0) {
                root = q1.poll();
                list.add(root.val);
                if (root.left != null) {
                    q1.offer(root.left);
                }
                if (root.right != null) {
                    q1.offer(root.right);
                }
                levelSize--;
            }
            out.add(list);
            list = new ArrayList<>();
        }
        return out;

    }

    public boolean compareTrees(Node rootA, Node rootB) {
        if (rootA == null && rootB == null) {
            return true;
        }
        if (rootA.val == rootB.val) {
            return compareTrees(rootA.left, rootB.left) && compareTrees(rootA.right, rootB.right);
        }
        return false;
    }

    @Test
    public void testCompareTreesNull() {
        Assert.assertEquals(true, compareTrees(null, null));
    }

    @Test
    public void testCompareTreesAreEqual() {
        long[] data = {6,4,5,2,3,4,6};
        Node treeA = createTree(data);
        Node treeB = createTree(data);
        Assert.assertEquals(true, compareTrees(treeA, treeB));
    }

    @Test
    public void testCompareTreesAreNotEqual() {
        long[] dataA = {6,4,5,2,3,4,6};
        long[] dataB = {6,4,5,2,3,5,6};
        Node treeA = createTree(dataA);
        Node treeB = createTree(dataB);
        Assert.assertEquals(false, compareTrees(treeA, treeB));
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
