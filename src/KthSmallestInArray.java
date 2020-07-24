
// Java code for kth smallest element in an array
import java.util.Arrays;
import java.util.Collections;

public class KthSmallestInArray {
  // Standard partition process of QuickSort.
  // It considers the last element as pivot
  // and moves all smaller element to left of
  // it and greater elements to right
  public static int partition(Integer [] arr, int l,
                      int r)
  { 
    int pos = (l+r)/2;
    int x = arr[pos], i = l, j = r;
    while ((i < r) && (j > 0) ) {
      while (arr[i] < x && i < j) {
        i++;
      }
      while (arr[j] > x && j > i) {
        j--;
      }
      if (i < j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
      i++;
    }
    
    return i;
  }

  // This function returns k'th smallest element
  // in arr[l..r] using QuickSort based method.
  // ASSUMPTION: ALL ELEMENTS IN ARR[] ARE DISTINCT
  public static int kthSmallest(Integer[] arr, int l,
                    int r, int k)
  {
    // If k is smaller than number of elements
    // in array
    if (k > 0 && k <= r - l + 1)
    {
      // Partition the array around last
      // element and get position of pivot
      // element in sorted array
      int pos = partition(arr, l, r);

      // If position is same as k
      if (pos-l == k-1)
        return arr[pos];

      // If position is more, recur for
      // left subarray
      if (pos-l > k-1)
        return kthSmallest(arr, l, pos-1, k);

      // Else recur for right subarray
      return kthSmallest(arr, pos+1, r, k-pos+l-1);
    }

    // If k is more than number of elements
    // in array
    return Integer.MAX_VALUE;
  }

  // Driver program to test above methods
  public static void main(String[] args)
  {
    Integer arr[] = new Integer[]{12,7,8, 6,3, 4, 19,26};
    int k = 3;
    System.out.print( "K'th smallest element is " +
          kthSmallest(arr, 0, arr.length - 1, k) );
  }
}



