import org.junit.*;
import static org.junit.Assert.*;

public class IntegerOverflowCheckTest {
	IntegerOverflowCheck chk;
	
	@Before
	public void setup() {
		chk = new IntegerOverflowCheck();
		
	}
	@Test
	public void addTest() {
		int result = chk.add(Integer.MAX_VALUE);
		assertEquals(Integer.MAX_VALUE,result );
	}
	
	@Test(expected=RuntimeException.class)
	public void addTestOverflow() {
		int result = chk.add(Integer.MAX_VALUE);
		result = chk.add(10);
	}
}