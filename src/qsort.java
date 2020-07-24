import java.util.Arrays;

class Qsort {
	int [] values = { 3,8,5,2,9,12,7};

	public static void main(String [] args) {
		Qsort q = new Qsort();
		System.out.println( Arrays.toString(q.values)); 
		//System.exit(0);
		q.sort();
		System.out.println( Arrays.toString(q.values));
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
	}
}
		
		