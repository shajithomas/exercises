import org.junit.Assert;
import org.junit.Test;

import java.util.*;

// failed test case
// [1,10,5,1,0,6,12]
// expected "" (equal), but returned Left
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
    public static String createBst(long[] arr) {
        if ( arr == null || arr.length == 0 ) { return "";}
        // create a tree structure and process
        Queue<Node> q = new LinkedList<Node>();
        Node root = new Node(arr[0], null, null);
        q.add(root);
        Node current;
        Node left, right;
        Long lVal = arr[0];
        Long rVal = arr[0];
        for ( int i = 1; i< arr.length; i += 2) {
            current = q.poll();
            left = new Node(arr[i]);
            q.add(left);
            lVal += left.val;
            if ((i+1) >= arr.length ) {
                right = null;
            } else {
                right = new Node(arr[i+1]);
                q.add(right);
                rVal += right.val;
            }
            current.left = left;
            current.right = right;
        }
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
    // expected "" (equal)
    public void testCreateTree() {
        long[] testArray = {1,10,5,1,0,6,12};
        BstHired bst = new BstHired();
        String expected = "";
        Assert.assertEquals(expected, bst.createBst(testArray));
    }
}
