import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class ArrayTestTest {
	private ArrayTest test;
	@Before
	public void setup(){
		test = new ArrayTest();
	}
	
	@Test
	public void testReverseArray() {
		Integer[] array = {1,2,3,4,5,6};
		Integer []expected = {6,5,4,3,2,1};
		Integer []result = test.reverseArray(array);
		assertArrayEquals("something wrong with AssertArrayEquals",expected, result);
	}
	
	@Test
	public void testReverseArray2() {
		Integer[] array = {1,2,3,4,5,6,7};
		Integer []expected = {7,6,5,4,3,2,1};
		Integer []result = test.reverseArray(array);
		assertEquals(expected, result);
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
	public void rotateArray() {
		int[] array = {3, 8, 9, 7, 6};
		int []expected = {9,7,6,3,8};
		int []result = test.rotate(array, 3);
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


}
