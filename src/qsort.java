import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

class Qsort {
//	int [] values = { 3,8,5,2,9,12,7};
	int [] values = { 1, 3, 5, 2, 4, 6, 7};

	int swapCount = 0;
	public static void main(String [] args) {
		Qsort q = new Qsort();
		System.out.println( Arrays.toString(q.values)); 
		//System.exit(0);
		q.sort();
		System.out.println( Arrays.toString(q.values));
		System.out.println("Min swaps = " + q.swapCount);
	}
	
	private void sort() {
		if ( values == null || values.length < 2) {
			return;
		}
		int low = 0;
		int high = values.length-1;
		qsort ( low, high);
	}

	private void qsort(int lo, int hi) {
		int i = lo;
		int j = hi;
		int pivotIndex = (lo + hi)/2;
		int pivot = values[pivotIndex];
		
		while ( i <= j ) {
			System.out.println( Arrays.toString(values));
			System.out.println( lo + " " + hi + " " + pivotIndex + " " + pivot); 
			System.out.println( "i= " + i + "j= " + j); 
			while( values[i] < pivot ) i++;
			while( values[j] > pivot ) j--;
			if ( i <= j ) {
				swap ( i, j );
				i++;
				j--;
			}
		}
		
		if ( lo < j ){
			System.out.println(" sort left" + lo + "," + j );
			qsort (lo,j);
		}
		if ( i < hi ) {
			System.out.println( "sort right" + i + "," + hi );
			qsort(i, hi);
		}
	}
	
	private void swap( int a, int b) {
		int temp = values[a];
		values[a] = values[b];
		values[b] = temp;

		if ( a != b) {
			swapCount++;
		}
	}

	public void qSort2(int[] a, int low, int high) {

		if ( low >= high) return;

		int i = low;
		int j = high;
		int mid = (low + high)/2;
		int pivot = a[mid];

		while (i <= j) {
			while (a[i] < pivot) { i++; }
			while (a[j] > pivot) { j--; }
			if (i <= j) {
				swap(a, i, j);
				i++;
				j--;
			}
		}
		qSort2(a, low, j);
		qSort2(a, i, high);
	}

	private void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static class UnitTest{
		@Test
		public void testQsort2_odd() {
			int [] values = { 1, 3, 5, 2, 4, 6, 7};
			int[] expected = {1,2,3,4,5,6,7};
			System.out.println(Arrays.toString(values));
			Qsort sorter = new Qsort();
			sorter.qSort2(values, 0, values.length-1);
			System.out.println(Arrays.toString(values));
			Assert.assertArrayEquals(expected, values);
		}

		@Test
		public void testQsort2_even() {
			int [] values = { 1, 3, 5, 2, 4, 6};
			int[] expected = {1,2,3,4,5,6};
			System.out.println(Arrays.toString(values));
			Qsort sorter = new Qsort();
			sorter.qSort2(values, 0, values.length-1);
			System.out.println(Arrays.toString(values));
			Assert.assertArrayEquals(expected, values);
		}

		@Test
		public void testQsort2_duplicates() {
			int [] values = { 1, 3, 1, 5, 3, 2, 4, 6};
			int[] expected = {1,1,2,3,3,4,5,6};
			System.out.println(Arrays.toString(values));
			Qsort sorter = new Qsort();
			sorter.qSort2(values, 0, values.length-1);
			System.out.println(Arrays.toString(values));
			Assert.assertArrayEquals(expected, values);
		}


	}
}
		
		