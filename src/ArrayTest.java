/*
 * Different Array operations
 */

import java.util.*;
import java.util.stream.Collectors;

public class ArrayTest {
    public static void main(String[] args) {
        ArrayTest test = new ArrayTest();
        Integer[] a = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8};
        test.reverseArray(a);
    }

    //* How to reverse an array efficiently
    public Integer[] reverseArray(Integer[] array) {
        if (array == null) {
            throw new RuntimeException("You passed in a null array");
        }
        int len = array.length;
        for (int i = 0; i < len / 2; i++) {
            System.out.println("i : " + i);
            int temp = array[i];
            array[i] = array[len - 1 - i];
            array[len - 1 - i] = temp;
        }
        System.out.println(Arrays.toString(array));
        return array;
    }

    public int[] reverseArray2(int[] a) {
        int start = 0;
        int end = a.length - 1;
        while (start < end) {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }
        return a;
    }

    /*
     a =  1 2 3 4 5
     k  = 2
     */
    public int[] rotate(int[] A, int K) {
        int len = A.length;
        int[] result = new int[len];
        int j = 0;
        K = K % len;
        if (K == 0) {
            return A;
        }
        for (int i = len - K; i < len; i++) {
            result[j] = A[i];
            j++;
        }
        for (int i = 0; i < len - K; i++) {
            System.out.println("j = " + j + "  i = " + i);
            result[j] = A[i];
            j++;
        }
        return result;
    }

    /*
     a = 1 2 3 4 5 6 7
     k = 2
     len = 7
     */
    public int[] rotateArrayInPlace(int[] a, int k) {
        int len = a.length;
        k = k % len;
        reverseArray(a, 0, len - k - 1);
        reverseArray(a, len - k, len - 1);
        reverseArray(a, 0, len - 1);
        return a;
    }

    private void reverseArray(int[] a, int start, int end) {
        while (start < end) {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }
    }

    /*
    A non-empty array A consisting of N integers is given. The array contains an odd number of elements, and each element of the array can be paired with another element that has the same value, except for one element that is left unpaired.

    For example, in array A such that:

      A[0] = 9  A[1] = 3  A[2] = 9
      A[3] = 3  A[4] = 9  A[5] = 7
      A[6] = 9
    the elements at indexes 0 and 2 have value 9,
    the elements at indexes 1 and 3 have value 3,
    the elements at indexes 4 and 6 have value 9,
    the element at index 5 has value 7 and is unpaired.
    Write a function:

    class Solution { public int solution(int[] A); }

    that, given an array A consisting of N integers fulfilling the above conditions, returns the value of the unpaired element.

    For example, given array A such that:

      A[0] = 9  A[1] = 3  A[2] = 9
      A[3] = 3  A[4] = 9  A[5] = 7
      A[6] = 9
    the function should return 7, as explained in the example above.

    Write an efficient algorithm for the following assumptions:

    N is an odd integer within the range [1..1,000,000];
    each element of array A is an integer within the range [1..1,000,000,000];
    all but one of the values in A occur an even number of times.
    */
    public int detectUnpaired(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int element : A) {
            if (map.containsKey(element)) {
                map.remove(element);
            } else {
                map.put(element, 1);
            }
        }
        int result = (Integer) map.keySet().toArray()[0];
        return result;
    }

    /*
        Given a non-empty array of integers, return the k most frequent elements.

        Example 1:

        Input: nums = [1,1,1,2,2,3], k = 2
        Output: [1,2]
        Example 2:

        Input: nums = [1], k = 1
        Output: [1]
        Note:

        You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
        Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
        It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
        You can return the answer in any order.
     */
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
//			map.merge(num, 1, (a1, a2) -> a1 + a2 ); // -- the entire code below can be replaced with this one line
//			map.merge(num, 1, Integer::sum);
            Integer value = map.get(num);
            if (value == null) {
                map.put(num, 1);
            } else {
                map.put(num, value + 1);
            }
        }

        //sort the map into list of Map.Entry
        List<Map.Entry<Integer, Integer>> sorted = sortedEntries(map);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            Map.Entry<Integer, Integer> entry = sorted.get(i);
            result[i] = entry.getKey();
        }
        return result;
    }

    private List<Map.Entry<Integer, Integer>> sortedEntries(HashMap<Integer, Integer> map) {
        return map.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue() - e1.getValue())
                .collect(Collectors.toList());
    }

    //sorts using Collections.sort
    public int[] topKFrequent2(int[] nums, int k) {
//		TreeMap<Integer, Integer> map = new TreeMap<>((e1,e2) -> e2.intValue() - e1.intValue());
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer value = map.get(num);
            if (value == null) {
                map.put(num, 1);
            } else {
                map.put(num, value + 1);
            }
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((e1, e2) -> e2.getValue() - e1.getValue());
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i).getKey();
        }
        return result;
    }

    //using priority Queue
    public int[] topKFrequent3(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer value = map.get(num);
            if (value == null) {
                map.put(num, 1);
            } else {
                map.put(num, value + 1);
            }
        }

        // put them into a priority Queue and trim them when reaching the K size
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(
                Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[] result = new int[k];
        int i = k - 1;
        for (Map.Entry<Integer, Integer> entry : queue) {
            result[i--] = entry.getKey();
        }
        return result;
    }


    /*
    An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.

    Your goal is to find that missing element.

    Write a function:

    class Solution { public int solution(int[] A); }

    that, given an array A, returns the value of the missing element.

    For example, given array A such that:

      A[0] = 2
      A[1] = 3
      A[2] = 1
      A[3] = 5
    the function should return 4, as it is the missing element.

    Write an efficient algorithm for the following assumptions:

    N is an integer within the range [0..100,000];
    the elements of A are all distinct;
    each element of array A is an integer within the range [1..(N + 1)].
    */
    public int findMissing(int[] A) {
        if (A.length == 0) {
            return 1;
        }

        Arrays.sort(A);

        if (A[0] != 1) {
            return 1;
        }

        for (int i = 0; i < A.length - 1; i++) {
            if ((A[i] + 1) != A[i + 1]) {
                return A[i] + 1;
            }
        }

        return A[A.length - 1] + 1;
    }

    /*
        Write a function:

        class Solution { public int solution(int[] A); }

        that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

        For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

        Given A = [1, 2, 3], the function should return 4.

        Given A = [−1, −3], the function should return 1.

        Write an efficient algorithm for the following assumptions:

        N is an integer within the range [1..100,000];
        each element of array A is an integer within the range [−1,000,000..1,000,000
    */
    public int findMissingInt(int[] A) {
        Arrays.sort(A);
        if (A[A.length - 1] <= 0) {
            return 1;
        }

        for (int i = 1; i <= A.length; i++) {
            if (Arrays.binarySearch(A, i) < 0)
                return i;
        }
        return A[A.length - 1] + 1;
    }

/*
1. MaxCounters
Calculate the values of counters after applying all alternating operations: increase counter by 1; set value of all counters to current maximum.


You are given N counters, initially set to 0, and you have two possible operations on them:

increase(X) − counter X is increased by 1,
max counter − all counters are set to the maximum value of any counter.
A non-empty array A of M integers is given. This array represents consecutive operations:

if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
if A[K] = N + 1 then operation K is max counter.
For example, given integer N = 5 and array A such that:

    A[0] = 3
    A[1] = 4
    A[2] = 4
    A[3] = 6
    A[4] = 1
    A[5] = 4
    A[6] = 4
the values of the counters after each consecutive operation will be:

    (0, 0, 1, 0, 0)
    (0, 0, 1, 1, 0)
    (0, 0, 1, 2, 0)
    (2, 2, 2, 2, 2)
    (3, 2, 2, 2, 2)
    (3, 2, 2, 3, 2)
    (3, 2, 2, 4, 2)
The goal is to calculate the value of every counter after all operations.

Write a function:

class Solution { public int[] solution(int N, int[] A); }

that, given an integer N and a non-empty array A consisting of M integers, returns a sequence of integers representing the values of the counters.

Result array should be returned as an array of integers.

For example, given:

    A[0] = 3
    A[1] = 4
    A[2] = 4
    A[3] = 6
    A[4] = 1
    A[5] = 4
    A[6] = 4
the function should return [3, 2, 2, 4, 2], as explained above.

Write an efficient algorithm for the following assumptions:

N and M are integers within the range [1..100,000];
each element of array A is an integer within the range [1..N + 1].
*/

    public int[] maxCounters(int N, int[] A) {
        int[] result = new int[N];
        for (int num : A) {
            if (num == N + 1) {
                maxAllCounter(result);
            } else {
                result[num - 1]++;
            }
        }
        return result;
    }

    private void maxAllCounter(int[] result) {
        int max = result[0];
        for (int counter : result) {
            if (max < counter) {
                max = counter;
            }
        }
        Arrays.fill(result, max);
		/* replacing with the above line
			for (int i=0; i< result.length; i++) {
				result[i] = max;
			}
		*/
    }

    /*
    A non-empty array A consisting of N integers is given.

    A permutation is a sequence containing each element from 1 to N once, and only once.

    For example, array A such that:

        A[0] = 4
        A[1] = 1
        A[2] = 3
        A[3] = 2
    is a permutation, but array A such that:

        A[0] = 4
        A[1] = 1
        A[2] = 3
    is not a permutation, because value 2 is missing.

    The goal is to check whether array A is a permutation.

    Write a function:

    class Solution { public int solution(int[] A); }

    that, given an array A, returns 1 if array A is a permutation and 0 if it is not.

    For example, given array A such that:

        A[0] = 4
        A[1] = 1
        A[2] = 3
        A[3] = 2
    the function should return 1.

    Given array A such that:

        A[0] = 4
        A[1] = 1
        A[2] = 3
    the function should return 0.

    Write an efficient algorithm for the following assumptions:

    N is an integer within the range [1..100,000];
    each element of array A is an integer within the range [1..1,000,000,000].
     */
    public int permCheck(int[] A) {
        if (A.length < 2) {
            return 1;
        }
        Set<Integer> set = new HashSet<>();
        for (int element : A) {
            set.add(element);
        }
        // there are duplicates
        if (set.size() != A.length) {
            return 0;
        }

        Arrays.sort(A);
        int len = A[A.length - 1] - A[0];
        if (len + 1 == A.length) {
            return 1;
        } else {
            return 0;
        }
    }

    /*
    Guidewire interview Question.

    Given an string containing letters of the alphabet ( uppercase & lowercase ),
    find the largest alphabet that exists in the string which has both the uppercse and corresponding lowercase
    character.
    Example:
    String s = "aaBabcDaA";
    largest alphabet that has both upper and lowercase is B

    it should return "NO" if there are no such character,
    otherwise return the uppercase Character.

     */
    public String findLargestChar(String s) {
        char[] ss = s.toCharArray();
        Set<Character> charSet = new HashSet<>();
        Arrays.sort(ss);
        for (int i = 0; (i < ss.length && Character.isUpperCase(ss[i])); i++) {
            char toFind = Character.toLowerCase(ss[i]);
            if (Arrays.binarySearch(ss, toFind) >= 0) {
                charSet.add(ss[i]);
            }
        }
        if (charSet.size() == 0) {
            return "NO";
        }
        List<Character> charList = new ArrayList<>(charSet);
//        Collections.sort(charList);
        charList.sort(null);
        Character c = charList.get(charList.size() - 1);
        return String.valueOf(c);
    }

    /*
        from: Equinix
        Problem:
            Given an array of integers, return indices of the two numbers such that they add up to a specific target.

            Input: int[] nums, int target
            Output: int[]

            Example:
            Given nums = [1, 6, 11, 14], target = 12,
            Because nums[0] + nums[2] = 1 + 11 = 12,
            return [0, 2]

            ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public static int[] findTargetNumbers(int[] nums, int target) {

        int[] result = new int[2];
        Map<Integer, Integer> map = new LinkedHashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < n - 1; i++) {
            int toCheck = target - nums[i];
            Integer toCheckIndex = map.get(toCheck);
            if (toCheckIndex != null) {
                result[0] = i;
                result[1] = toCheckIndex;
                return result;
            }
        }
        return null;
    }

    /**
     * Given a list of strings and an array with length 'n',
     * find the max numbers of strings from the list that can fit in the array
     * with 1 space between the strings
     */

    public static int maxNumOfStringsFit(List<String> strings, int arrayLen) {
        //sort ascending so that the shortest ones are in the beginning and can be used.
        strings.sort(Comparator.comparing(String::length));
/*
        strings.sort( (s1, s2) -> {
            return s1.length() - s2.length();
                });
*/
        System.out.println(strings);
        int len = 0;
        int i = 0;
        StringBuilder strBuilder = new StringBuilder();
        while (len < arrayLen && i < strings.size()) {
            String str = strings.get(i);
            if ((str.length() + len + 1) < arrayLen) {
                strBuilder.append(str + " ");
                len += str.length() + 1;
                i++;
            } else {
                break;
            }
        }
        printStrings(strBuilder);
        return i;
    }

    private static void printStrings(StringBuilder strBuilder) {
        char[] chars = strBuilder.toString().toCharArray();
        System.out.println(strBuilder.toString());
        System.out.println(chars);
        System.out.println("length: " + strBuilder.length());
    }


}