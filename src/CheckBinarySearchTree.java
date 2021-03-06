/*
https://www.hackerrank.com/challenges/ctci-is-binary-search-tree/problem
*/
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CheckBinarySearchTree {
    /* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.

    The Node class is defined as follows:
*/
    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    boolean checkBST(Node root){
        if (root == null) return true;
        return isBST(root, 0, 10000);
    }

    boolean isBST(Node root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.data < min || root.data > max) {
            return false;
        }
        return (isBST(root.left,min,root.data-1) && isBST(root.right,root.data+1, max));
    }

    boolean checkBST2(Node root) {
        if ( root == null ) { return true; }
        return isBSTLeft(root.left, root) && isBSTRight(root.right, root);
    }

    boolean isBSTLeft(Node current, Node parent) {
        if ( current == null ) { return true; }
        if (current.data >= parent.data) { return false; }
        return isBSTLeft(current.left, current) && isBSTRight(current.right, current);
    }

    boolean isBSTRight(Node current, Node parent) {
        if ( current == null) { return true; }
        if (current.data <= parent.data) { return false; }
        return isBSTLeft(current.left, current) && isBSTRight( current.right, current);
    }

    @Test
    public final void testBST_false() {
        Node left = new Node(2, null, null);
        left.left = new Node(1, null, null);
        Node right = new Node(4, null, null);
        right.right = new Node(3, null, null);
        Node root = new Node(2, left, right);
        boolean expected = false;
        boolean result = checkBST(root);
        assertEquals(expected, result);
    }

    @Test
    public final void testBST_true() {
        Node left = new Node(1, null, null);
        left.left = new Node(0, null, null);
        Node right = new Node(3, null, null);
        right.right = new Node(4, null, null);
        Node root = new Node(2, left, right);
        boolean expected = true;
        boolean result = checkBST(root);
        assertEquals(expected, result);
    }

    @Test
    public final void testBST2_false() {
        Node left = new Node(2, null, null);
        left.left = new Node(1, null, null);
        Node right = new Node(4, null, null);
        right.right = new Node(3, null, null);
        Node root = new Node(2, left, right);
        boolean expected = false;
        boolean result = checkBST2(root);
        assertEquals(expected, result);
    }

    @Test
    public final void testBST2_true() {
        Node left = new Node(1, null, null);
        left.left = new Node(0, null, null);
        Node right = new Node(3, null, null);
        right.right = new Node(4, null, null);
        Node root = new Node(2, left, right);
        boolean expected = true;
        boolean result = checkBST2(root);
        assertEquals(expected, result);
    }


}
