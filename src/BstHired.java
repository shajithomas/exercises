/*
Check the wait of the branches of the tree and output
left if the left branch is heavier
right if the right branch is heavier
or "" if the weights are similar.
 */

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

// failed test case
// [1,10,5,1,0,6,12]
public class BstHired {
    static class Node {
        long val;
        Node left;
        Node right;
        public Node(long v, Node l, Node r) {
            val = v;
            left = l;
            right = r;
        }
        public Node(long v) {
            val = v;
            left = right = null;
        }
    }
    public static Node createBst(long[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        // create a tree structure and process
        Queue<Node> q = new LinkedList<Node>();
        Node root = new Node(arr[0], null, null);
        q.add(root);
        Node current;
        Node left, right;

        for (int i = 1; i < arr.length; i += 2) {
            current = q.poll();
            left = new Node(arr[i]);
            current.left = left;
            q.add(left);
            if ((i + 1) >= arr.length) {
                break;
            }
            right = new Node(arr[i + 1]);
            q.add(right);
            current.right = right;
        }
        return root;
    }

    public long computeWeight(Node tree) {
        if (tree == null) {
            return 0;
        }
        return tree.val + computeWeight(tree.left) + computeWeight(tree.right);
    }
    public String checkWeight(long[] treeData) {
        Node tree = createBst(treeData);
        long lVal = computeWeight(tree.left);
        long rVal = computeWeight(tree.right);

        System.out.println("left = " + lVal);
        System.out.println("right = " + rVal);
        if (lVal > rVal) {
            return "Left";
        } else if ( lVal < rVal){
            return "Right";
        }
        return "";
    }

    @Test
    // [1,10,5,1,0,6,12]
    // expected right (equal)
    public void testCreateTree_Right() {
        long[] testArray = {1,10,5,1,0,6,12};
        BstHired bst = new BstHired();
        String expected = "Right";
        String actual = bst.checkWeight(testArray);
        System.out.println(String.format("result = %s",actual));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCreateTree_left() {
        long[] testArray = {1,10,5,1,14,6,12};
        BstHired bst = new BstHired();
        String expected = "Left";
        String actual = bst.checkWeight(testArray);
        System.out.println(String.format("result = %s",actual));
        Assert.assertEquals(expected, actual);
    }

    @Test
    // expected right (equal)
    public void testCreateTree_equal() {
        long[] testArray = {1,10,5,1,0,6};
        BstHired bst = new BstHired();
        String expected = "";
        String actual = bst.checkWeight(testArray);
        System.out.println(String.format("result = %s",actual));
        Assert.assertEquals(expected, actual);
    }
}
