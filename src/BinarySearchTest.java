import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;


public class BinarySearchTest {

	@Test
	public final void testSearch() {
		int [] a = {1,2,3,4,6,7,7,8,9,10};
		int result = BinarySearch.search(a, 9);
		assertEquals(8,result);
		System.out.println("After test");
	}

	@Test
	public void testNonRecursiveSearch() {
		int [] buf = {1,2,3,4,5,6,7,8};
		BinarySearch bin = new BinarySearch();
		bin.setBuf(buf);
		Arrays.stream(bin.buf).forEach(System.out::println);
		int result = bin.nonRecursiveSearch(7);
		System.out.println("searched index is: " +  result);
		Assert.assertEquals(6, result);
	}

	@Test
	public final void testNull() {
		assertNotNull(new Integer(1));
	}

}
