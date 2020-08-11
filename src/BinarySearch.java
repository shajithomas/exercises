import java.util.Arrays;

public class BinarySearch {
//	int [] buf = {1,2,3,4,5,6,7,8};
	int[] buf;

	public void setBuf(int[] buf) {
		this.buf = buf;
	}

	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 6, 7, 7, 8, 9, 10};
		int result = search(a, 8);
		System.out.println("The result is: " + result);

		BinarySearch bin = new BinarySearch();
		Arrays.stream(bin.buf).forEach(System.out::println);
		System.out.println("searched index is: " +  bin.nonRecursiveSearch(7));
	}

	public static int search(int[] buf, int n) {
		int hi = buf.length - 1;
		int low = 0;
		return binSearch(buf, low, hi, n);
	}

	public static int binSearch(int[] buf, int low, int hi, int n) {
		int mid = (hi + low) / 2;
		System.out.println("low, high, mid = " + low + " " + hi + " " + mid);
		if (hi < low) return -1;
		if (buf[mid] == n) {
			return mid;
		} else if (n > buf[mid]) {
			return binSearch(buf, mid + 1, hi, n);
		} else {
			return binSearch(buf, low, mid - 1, n);
		}
	}

	public int nonRecursiveSearch(int n) {
		int low = 0;
		int high = buf.length-1;

		while (low < high) {
			int mid = (high + low) / 2;
			if (n == buf[mid]) {
				return mid;
			}
			if (n < buf[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}
}	

