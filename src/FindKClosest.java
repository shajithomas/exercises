import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
Find k closest elements to a given value
Last Updated: 28-06-2019
Given a sorted array arr[] and a value X, find the k closest elements to X in arr[].
Examples:

Input: K = 4, X = 35
       arr[] = {12, 16, 22, 30, 35, 39, 42,
               45, 48, 50, 53, 55, 56}
Output: 30 39 42 45
Note that if the element is present in array, then it should not be in output, only the other closest elements are required.

Recommended: Please solve it on “PRACTICE ” first, before moving on to the solution.
In the following solutions, it is assumed that all elements of array are distinct.

A simple solution is to do linear search for k closest elements.
1) Start from the first element and search for the crossover point (The point before which elements are smaller than or equal to X and after which elements are greater). This step takes O(n) time.
2) Once we find the crossover point, we can compare elements on both sides of crossover point to print k closest elements. This step takes O(k) time.

The time complexity of the above solution is O(n).


 */
public class FindKClosest {

    public int[] kClosestElements(int[] a, int element, int k) {
        int len = a.length;
        int[] out = new int[k];

//        int i = getElementIndex(a, element);
        int i = getElementIndexBinSearch(a, element);

        int count = 0;
        int l = i, r = i;

        int left, right;
        while (count < k && l >= 0 && r < len) {
            left = a[l];
            right = a[r];

            //skip if the element is equal to current number
            if (a[l] == element) {
                l--;
                continue;
            }
            if (a[r] == element ) {
                r++;
                continue;
            }

            // move the counters to left and right and check the nearest one and add to list.
            if (element - left < right - element ) {
              out[count++] = left;
              l--;
            } else if (element - left > right - element ) {
                out[count++] = right;
                r++;
            } else {
                out[count++] = left; l--;
                if ( count < k ) {
                    out[count++] = right;
                    r++;
                }
            }
        }

        // if the left or right end of the list is reached, continue right or left accordingly until K numbers are added
        if (l < 0) {
            while ( r < len && count < k) {
                if (a[r] == element) {
                    r++;
                    continue;
                }
                out[count++] = a[r++];
            }
        }
        if (r >= len) {
            while (l >= 0 && count < k) {
                if (a[l] == element) {
                    l--;
                    continue;
                }
                out[count++] = a[l--];
            }
        }
        return out;
    }

    private int getElementIndex(int[] a, int element) {
        int len = a.length;
        int i = 0;
        while (i < len && a[i] < element) {
            i++;
        }
        return i;
    }

    private int getElementIndexBinSearch(int[] a, int element) {
        return binSearch(a, element, 0, a.length-1);
    }

    private int binSearch(int[] a, int element, int low, int high) {
        if (a[high] <= element) {
            return high;
        }
        if ( a[low] > element) {
            return low;
        }
        int mid = (high + low )/2;
        if (a[mid] <= element && a[mid+1] > element) {
            return mid;
        }
        if ( element < a[mid] ) {
            return binSearch(a, element, low, mid-1);
        }
        return binSearch(a, element, mid+1, high);
    }

    public static class Pair{
        int distance;
        int element;
        public Pair(int d, int e) {
            this.distance = d;
            this.element = e;
        }
    }

    //implementation using priority Queue
    public int[] findKClosestElements(int[] a, int element, int k) {
        int[] out = new int[k];
        PriorityQueue<Pair> queue = new PriorityQueue<>( (e1,e2) -> e2.distance - e1.distance);
        int index = getElementIndex(a,element);
        // get K elements to the left
        int l = index-1, r = index;
        while (l >= 0 && (index - l) <= k ) {
            if (a[l] == element) {
                continue;
            }
            queue.offer(new Pair(element - a[l], a[l]));
            l--;
        }
        while (r < a.length && (r - index) <= k)  {
            if (a[r] == element) {
                r++;
                continue;
            }
            queue.offer(new Pair(a[r]-element, a[r]));
            r++;

            if (queue.size() > k) {
                queue.poll();
            }
        }
        int i = 0;
        for (Pair pair : queue) {
            out[i++] = pair.element;
        }
        return out;
    }

    public static class UnitTest{

        @Test
        public void findKclosest() {
            int[] a =  {12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56};
            int k = 4;
            int element = 35;
            int[] expected = {30, 39, 42, 45};

            FindKClosest test = new FindKClosest();
            int[] result = test.kClosestElements(a, element, k);
            Arrays.sort(result);
            Assert.assertArrayEquals(expected, result);
        }

        @Test
        public void findKclosest_element_at_left() {
            int[] a =  {12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56};
            int k = 4;
            int element = 12;
            int[] expected = {16, 22, 30, 35};

            FindKClosest test = new FindKClosest();
            int[] result = test.kClosestElements(a, element, k);
            Arrays.sort(result);
            Assert.assertArrayEquals(expected, result);
        }

        @Test
        public void findKclosest_element_near_left() {
            int[] a =  {12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56};
            int k = 4;
            int element = 16;
            int[] expected = {12, 22, 30, 35};

            FindKClosest test = new FindKClosest();
            int[] result = test.kClosestElements(a, element, k);
            Arrays.sort(result);
            Assert.assertArrayEquals(expected, result);
        }

        @Test
        public void findKclosest_element_at_right() {
            int[] a =  {12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56};
            int k = 4;
            int element = 56;
            int[] expected = {48, 50, 53, 55};

            FindKClosest test = new FindKClosest();
            int[] result = test.kClosestElements(a, element, k);
            Arrays.sort(result);
            Assert.assertArrayEquals(expected, result);
        }

        @Test
        public void findKclosest_element_near_right() {
            int[] a =  {12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56};
            int k = 4;
            int element = 53;
            int[] expected = {48, 50, 55, 56};

            FindKClosest test = new FindKClosest();
            int[] result = test.kClosestElements(a, element, k);
            Arrays.sort(result);
            Assert.assertArrayEquals(expected, result);
        }


        @Test
        public void findKclosest_Q() {
            int[] a =  {12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56};
            int k = 4;
            int element = 35;
            int[] expected = {30, 39, 42, 45};

            FindKClosest test = new FindKClosest();
            int[] result = test.findKClosestElements(a, element, k);
            Arrays.sort(result);
            Assert.assertArrayEquals(expected, result);
        }

        @Test
        public void findKclosest_element_at_left_Q() {
            int[] a =  {12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56};
            int k = 4;
            int element = 12;
            int[] expected = {16, 22, 30, 35};

            FindKClosest test = new FindKClosest();
            int[] result = test.findKClosestElements(a, element, k);
            Arrays.sort(result);
            Assert.assertArrayEquals(expected, result);
        }

        @Test
        public void findKclosest_element_near_left_Q() {
            int[] a =  {12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56};
            int k = 4;
            int element = 16;
            int[] expected = {12, 22, 30, 35};

            FindKClosest test = new FindKClosest();
            int[] result = test.findKClosestElements(a, element, k);
            Arrays.sort(result);
            Assert.assertArrayEquals(expected, result);
        }

        @Test
        public void findKclosest_element_at_right_Q() {
            int[] a =  {12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56};
            int k = 4;
            int element = 56;
            int[] expected = {48, 50, 53, 55};

            FindKClosest test = new FindKClosest();
            int[] result = test.findKClosestElements(a, element, k);
            Arrays.sort(result);
            Assert.assertArrayEquals(expected, result);
        }

        @Test
        public void findKclosest_element_near_right_Q() {
            int[] a =  {12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56};
            int k = 4;
            int element = 53;
            int[] expected = {48, 50, 55, 56};

            FindKClosest test = new FindKClosest();
            int[] result = test.findKClosestElements(a, element, k);
            Arrays.sort(result);
            Assert.assertArrayEquals(expected, result);
        }


    }
}
