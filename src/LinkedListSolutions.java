import org.junit.Assert;
import org.junit.Test;

public class LinkedListSolutions {

    /*
     Find the Kth node from last
     */
    public MyNode findKthNodeFromLast(MyNode node, int k) {
        int i=0;
        MyNode curNode = node;
        while (curNode.next != null && i < k-1) {
            curNode = curNode.next;
            i++;
        }
        MyNode kthNode = node;
        while (curNode.next != null) {
            curNode = curNode.next;
            kthNode = kthNode.next;
        }
        return kthNode;
    }

    public static class MyNode {
        int data;
        MyNode next;
        MyNode(int data) {
            this.data = data;
            next = null;
        }
    }

    public static class UnitTests {
        @Test
        public void findKthNodeFromLast() {
            LinkedListSolutions test = new LinkedListSolutions();
            MyNode head = new MyNode(5);
            MyNode curNode = head;
            curNode.next = new MyNode(7);
            curNode = curNode.next;
            curNode.next = new MyNode(9);
            curNode = curNode.next;
            curNode.next = new MyNode(1);
            curNode = curNode.next;
            curNode.next = new MyNode(3);
            curNode = curNode.next;
            curNode.next = new MyNode(12);

            MyNode kth = test.findKthNodeFromLast(head, 2);
            Assert.assertEquals(3, kth.data);

            kth = test.findKthNodeFromLast(head, 4);
            Assert.assertEquals(9, kth.data);
        }
    }
}
