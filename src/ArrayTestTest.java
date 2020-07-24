import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class ArrayTestTest {
	private ArrayTest test;
	@Before
	public void setup(){
		test = new ArrayTest();
	}
	
	@Test
	public void testReverseArray() {
		Integer[] array = {1,2,3,4,5,6,7};
		Integer []expected = {7,6,5,4,3,2,1};
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
	
}
