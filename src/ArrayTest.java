/*
* Different Array operations
*/
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.*;

public class ArrayTest {
	private Integer []array;
	public static void main ( String [] args ) {
		ArrayTest test = new ArrayTest();
		Integer []a = new Integer[] {1,2,3,4,5,6,7,8};
		test.reverseArray(a);
	}

//* How to reverse an array efficiently
 public Integer[] reverseArray(Integer []array){
		if ( array == null) {
			throw new RuntimeException("You passed in a null array");
		}
		this.array = array;
		int len = array.length;
		for ( int i = 0; i < len/2; i++ ) {
			System.out.println( "i : " +i);
			int temp = array[i];
			array[i] = array[len-1-i];
			array[len-1-i] = temp;
		}
		System.out.println( Arrays.toString(array));
		return array;
	}

	public int[] rotate(int[] A, int K) {
		int len = A.length;
		int[] result = new int[len];
		int j = 0;
		K = K % len;
		if ( K ==0) {
			return A;
		}
		for (int i = len-K; i < len; i++) {
			result[j] = A[i];
			j++;
		}
		for (int i = 0; i < len-K; i++) {
			System.out.println("j = " + j + "  i = " + i);
			result[j] = A[i];
			j++;
		}
		return result;
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
		int result =  (Integer)map.keySet().toArray()[0];
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
			//map.merge(num, 1, Integer::sum); -- the entire code below can be replaced with this one line
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
		for (int i=0; i<k; i++) {
			Map.Entry<Integer, Integer> entry = sorted.get(i);
			result[i] = entry.getKey();
		}
		return result;
	}

	private List<Map.Entry<Integer, Integer>> sortedEntries(HashMap<Integer, Integer>map) {
		return map.entrySet().stream()
				.sorted((e1,e2) -> e2.getValue() - e1.getValue())
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
		for (int i = 0; i<k; i++) {
			result[i] = list.get(i).getKey();
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

		for (int i = 0; i< A.length-1; i++) {
			if ( (A[i] +1) != A[i+1] ) {
				return A[i]+1;
			}
		}

		return A[A.length-1] +1;
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
		int len = A[A.length-1] - A[0];
		if ( len+1 == A.length) {
			return 1;
		} else {
			return 0;
		}
	}
}