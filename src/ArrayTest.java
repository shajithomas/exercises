/*
* How to reverse an array efficiently
*/
import java.util.Arrays;
public class ArrayTest {
	private Integer []array;
	public static void main ( String [] args ) {
		ArrayTest test = new ArrayTest();
		Integer []a = new Integer[] {1,2,3,4,5,6,7,8};
		test.reverseArray(a);
	}

	public Integer[] reverseArray(Integer []array){
		
		if ( array == null) {
			throw new RuntimeException("You passed in a null array");
		}
		this.array = array;
		int len = array.length;
		for ( int i = 0; i < len/2; i++ ) {
			System.out.println( "i : " +i);
			int temp = array[i];
			array[i] = array[len-i-1];
			array[len-i-1] = temp;
		}
		System.out.println( Arrays.toString(array));
		return array;
	}
}