import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ArrayTestTest {
	private ArrayTest test;
	@Before
	public void setup(){
		test = new ArrayTest();
	}
	
	@Test
	public void reverseArrayTest() {
		Integer[] array = {1,2,3,4,5,6};
		Integer []expected = {6,5,4,3,2,1};
		Integer []result = test.reverseArray(array);
		assertArrayEquals("something wrong with AssertArrayEquals",expected, result);
	}
	
	@Test
	public void reverseArrayTest2() {
		Integer[] array = {1,2,3,4,5,6,7};
		Integer []expected = {7,6,5,4,3,2,1};
		Integer []result = test.reverseArray(array);
		assertEquals(expected, result);
	}

	@Test
	public void reverseArrayTest3() {
		Integer[] array = {1,2};
		Integer []expected = {2,1};
		Integer []result = test.reverseArray(array);
		assertEquals(expected, result);
	}

	@Test
	public void reverseArray2Test() {
		int[] array = {1,2,3,4,5,6};
		int []expected = {6,5,4,3,2,1};
		int []result = test.reverseArray2(array);
		assertArrayEquals("something wrong with AssertArrayEquals",expected, result);
	}

	@Test
	public void reverseArray2Test2() {
		int[] array = {1,2,3,4,5,6,7};
		int[] expected = {7,6,5,4,3,2,1};
		int[] result = test.reverseArray2(array);
		assertArrayEquals(expected, result);
	}

	@Test
	public void reverseArray2Test3() {
		int[] array = {1,2};
		int []expected = {2,1};
		int []result = test.reverseArray2(array);
		assertArrayEquals(expected, result);
	}


	@Test(expected=RuntimeException.class)
	public void testReverseArrayException() {
		test.reverseArray(null);
	}

	@Test
	public void rotateArray2() {
		int[] array = {1,2,3,4,5,6,7};
		int []expected = {6,7,1,2,3,4,5};
		int []result = test.rotate(array, 2);
		assertArrayEquals("something wrong with AssertArrayEquals",expected, result);
	}

	@Test
	public void rotateArray3() {
		int[] array = {1,2,3,4,5,6,7};
		int []expected = {7,1,2,3,4,5,6};
		int []result = test.rotate(array, 1);
		assertArrayEquals("something wrong with AssertArrayEquals",expected, result);
	}

	@Test
	public void rotateArray() {
		int[] array = {3, 8, 9, 7, 6};
		int []expected = {9,7,6,3,8};
		int []result = test.rotate(array, 3);
		assertArrayEquals("something wrong with AssertArrayEquals",expected, result);
	}

	@Test
	public void rotateArrayInPlace2() {
		int[] array = {1,2,3,4,5,6,7};
		int []expected = {6,7,1,2,3,4,5};
		int []result = test.rotateArrayInPlace(array, 2);
		assertArrayEquals("something wrong with AssertArrayEquals",expected, result);
	}

	@Test
	public void rotateArrayInPlace() {
		int[] array = {3, 8, 9, 7, 6};
		int []expected = {9,7,6,3,8};
		int []result = test.rotateArrayInPlace(array, 3);
		assertArrayEquals("something wrong with AssertArrayEquals",expected, result);
	}

	@Test
	public void rotateArrayInPlace3() {
		int[] array = {3, 8, 9, 7, 6};
		int []expected = {3, 8, 9, 7, 6};
		int []result = test.rotateArrayInPlace(array, 5);
		assertArrayEquals("something wrong with AssertArrayEquals",expected, result);
	}

	@Test
	public void rotateArrayInPlace4() {
		int[] array = {3, 8, 9, 7, 6};
		int []expected = {6, 3, 8, 9, 7};
		int []result = test.rotateArrayInPlace(array, 6);
		assertArrayEquals("something wrong with AssertArrayEquals",expected, result);
	}

	@Test
	public void rotateArrayInPlace5() {
		int[] array = {1,2,3,4,5,6,7};
		int []expected = {7,1,2,3,4,5,6};
		int []result = test.rotateArrayInPlace(array, 1);
		assertArrayEquals("something wrong with AssertArrayEquals",expected, result);
	}

	@Test
	public void detectUnpaired() {
		int[] array = {9,3,9,3,9,7,9};
		int expected = 7;
		int result = test.detectUnpaired(array);
		assertEquals(expected, result);
	}

	@Test
	public void topKFrequent(){
		int[] array = {1,1,1,2,2,3,3,3,3};
		int[] result = test.topKFrequent(array, 2);
		System.out.println(Arrays.toString(result));
	}

	@Test
	public void topKFrequent2(){
		int[] array = {1,1,1,2,2,3,3,3,3};
		int[] result = test.topKFrequent2(array, 2);
		int[] expected = {3,1};
		System.out.println(Arrays.toString(result));
		Assert.assertArrayEquals(expected, result);
	}

	@Test
	public void topKFrequent2_2(){
		int[] array = {1,1,2,2,3,3,3,2,2,2};
		int[] result = test.topKFrequent2(array, 2);
		int[] expected = {2,3};
		System.out.println(Arrays.toString(result));
		Assert.assertArrayEquals(expected, result);
	}

	@Test
	public void topKFrequent3(){
		int[] array = {1,1,1,2,2,3,3,3,3};
		int[] result = test.topKFrequent3(array, 2);
		int[] expected = {3,1};
		System.out.println(Arrays.toString(result));
		Assert.assertArrayEquals(expected, result);
	}

	@Test
	public void topKFrequent3_2(){
		int[] array = {1,1,2,2,3,3,3,2,2,2};
		int[] result = test.topKFrequent3(array, 2);
		int[] expected = {2,3};
		System.out.println(Arrays.toString(result));
		Assert.assertArrayEquals(expected, result);
	}

	@Test
	public void findMissingEmpty() {
		int[] array = {};
		int result = test.findMissing(array);
		Assert.assertEquals(1, result);
	}

	@Test
	public void findMissing() {
		int[] array = {1,2,4,5,6,7};
		int result = test.findMissing(array);
		Assert.assertEquals(3, result);
	}

	@Test
	public void findMissingLast() {
		int[] array = {1,2,3,4,5,6,7};
		int result = test.findMissing(array);
		Assert.assertEquals(8, result);
	}

	@Test
	public void permCheckEmpty() {
		int[] array = {};
		Assert.assertEquals(1, test.permCheck(array));
	}
	@Test
	public void permCheckSingleElement() {
		int[] array = {0};
		Assert.assertEquals(1, test.permCheck(array));
	}
	@Test
	public void permCheck2Element() {
		int[] array = {100,101};
		Assert.assertEquals(1, test.permCheck(array));
	}

	@Test
	public void permCheckFalse() {
		int[] array = {100,2};
		Assert.assertEquals(0, test.permCheck(array));
	}


    @Test
    public void findMissingInt() {
    	int[] array = {1, 3, 6, 4, 1, 2};
    	ArrayTest test = new ArrayTest();
    	int result = test.findMissingInt(array);
    	Assert.assertEquals(5, result);
	}

	@Test
	public void maxCounters() {
		int N = 5;
		int[] A = {3,4,4,6,1,4,4};
		int[] expected = {3, 2, 2, 4, 2};
		ArrayTest test = new ArrayTest();
		int[] result = test.maxCounters(N, A);
		Assert.assertArrayEquals(expected, result);
	}
	@Test
	public void findLargestChar() {
		String s = "aaBabcDaA";
		ArrayTest test = new ArrayTest();
		Assert.assertEquals("B", test.findLargestChar(s));
	}

	@Test
	public void testTargetNumbers() {
		int[] nums = {1, 6, 11, 14};
		int target = 12;
		int[] expected = {0,2};
		int[] result = ArrayTest.findTargetNumbers(nums, target);
		Assert.assertArrayEquals(expected, result);
	}

	@Test
	public void maxNumOfStringsFit_Length_small() {
		List<String> strings = Arrays.asList("Henry", "Henry11", "Henry1", "David");
		int arrayLen = 20;
		int result = ArrayTest.maxNumOfStringsFit(strings, arrayLen);
		Assert.assertEquals(3, result);
	}

	@Test
	public void maxNumOfStringsFit_LargeLen() {
		List<String> strings = Arrays.asList("Henry", "Henry11", "Henry1", "David");
		int arrayLen = 100;
		int result = ArrayTest.maxNumOfStringsFit(strings, arrayLen);
		Assert.assertEquals(4, result);
	}

}
