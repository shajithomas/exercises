public class BinarySearch {
		public static void main ( String [] args) {
				int [] a = {1,2,3,4,6,7,7,8,9,10};
				int result = search ( a, 10);
				System.out.println ("The result is: " + result);
		}
		public static int search( int[] buf, int n ) {
				int hi = buf.length-1;
				int low = 0;
				return binSearch(buf, low, hi, n);
		}
		public static int binSearch( int [] buf, int low, int hi, int n) {
				int mid = (hi+low)/2;
				System.out.println( "low, high, mid = " + low + " " + hi + " " + mid);
				if ( hi < low ) return -1;
				if (buf[mid] == n ) { 
						return mid;
				} else if ( n > buf[mid] ) {
					return binSearch (buf, mid+1,hi,n);
				} else {
					return binSearch(buf, low, mid-1,n);
				}
		}
}	

