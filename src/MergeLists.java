/**
 You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

 Merge all the linked-lists into one sorted linked-list and return it.



 Example 1:

 Input: lists = [[1,4,5],[1,3,4],[2,6]]
 Output: [1,1,2,3,4,4,5,6]
 Explanation: The linked-lists are:
 [
 1->4->5,
 1->3->4,
 2->6
 ]
 merging them into one sorted list:
 1->1->2->3->4->4->5->6
 Example 2:

 Input: lists = []
 Output: []
 Example 3:

 Input: lists = [[]]
 Output: []


 Constraints:

 k == lists.length
 0 <= k <= 10^4
 0 <= lists[i].length <= 500
 -10^4 <= lists[i][j] <= 10^4
 lists[i] is sorted in ascending order.
 The sum of lists[i].length won't exceed 10^4

Leetcode link - https://leetcode.com/problems/merge-k-sorted-lists/

*/

/*
    use a priority Queue that orders by the val of the node
    Add head of all the lists to the priority queue if they are not null
    while Q is not empty, remove each node from Q and add to output and add the next node to the Q

 */

import org.junit.Before;
import org.junit.Test;

import java.util.*;
class MergeLists {
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode output = null;
        ListNode curNode = null;

        PriorityQueue<ListNode> q = new PriorityQueue<>((a,b) -> a.val - b.val);
        for (ListNode node : lists) {
            if ( node != null ) {
                q.offer(node);
            }
        }

        while (!q.isEmpty()) {
            ListNode node = q.poll();
            if (node == null) {
                continue;
            } else if (output == null) {
                output = curNode = node;
            } else {
                curNode.next = node;
                curNode = node;
            }

            if ( node.next != null ) {
                q.offer(node.next);
            }
        }
        return output;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static class UnitTest{

        /*
            input - [[1,4,5],[1,3,4],[2,6]]
            expected - [1,1,2,3,4,4,5,6]
         */
        ListNode[] lists = new ListNode[3];

        @Before
        public void setup() {
            ListNode node = new ListNode(1);
            ListNode list1 = node;
            node.next = new ListNode(4);
            node = node.next;
            node.next = new ListNode(5);

            node = new ListNode(1);
            ListNode list2 = node;
            node.next = new ListNode(3);
            node = node.next;
            node.next = new ListNode(4);

            node = new ListNode(2);
            ListNode list3 = node;
            node.next = new ListNode(6);

            lists[0] = list1;
            lists[1] = list2;
            lists[2] = list3;
        }

        @Test
        public void testMerge1() {

            ListNode node = MergeLists.mergeKLists(lists);
            while ( node!= null) {
                System.out.printf("%2d", node.val);
                node = node. next;
            }

        }

    }

}