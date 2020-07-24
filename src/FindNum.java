/**
 * Given an array of numbers, find the 1st 2 numbers whose sum = given number
 * Example: array = { 2,5,4,6,7,9,7}
 * num = 8
 * result = 0 & 3 ( the nubmers 2 and 6 )
 */
import java.util.Arrays;

class FindNum {
	public static void main ( String args[] ) {
		int [] array = { 5,8,9,2,4,6,1,2,3,6,8};
		int num = 5;
		
		int i=0;
		int j=1;
		
		while ( i < array.length-2 && j < array.length-1 ) {
			System.out.format ( "i = %d, j = %d, array(i) = %d, array(j) = %d, sum = %d\n", i,j,array[i], array[j], array[i]+array[j]);
			if ( array[i ] + array[j] == num ) {
				System.out.println ( " The number locations are :" + i + " , " + j); 
				System.out.println ( " The numbers are :" + array[i] + " , " + array[j]);
				return;
			}
			if ( j-i == 1 ) {
				i = 0;
				j++;
			} else {
				i++;
			}
		}
	};
}	
