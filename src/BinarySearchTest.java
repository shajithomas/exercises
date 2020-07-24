import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;


public class BinarySearchTest {

	@Test
	public final void testSearch() {
		int [] a = {1,2,3,4,6,7,7,8,9,10};
		int result = BinarySearch.search(a, 9);
		assertEquals(8,result);
		System.out.println("After test");
	}
	@Test
	public final void testNull() {
		assertNotNull(new Integer(1));
	}

}
