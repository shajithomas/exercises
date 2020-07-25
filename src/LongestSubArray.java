import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */
/*
  Given 2 arrays, find the longest sub-array between them
*/
class LongestSubArray {
  public static void main(String[] args) {
    int[] a1 = {1,2,6,7,7,8,9,10};
    int[] a2 = {2,3,5,6,7,8,9,10};
    int[] longest = findLongestSubArray(a1, a2);
    System.out.println(Arrays.toString(longest));
    
  }
  public static int[] findLongestSubArray(int[] a1, int[] a2){
    int[] subArray = {};
    for (int i=0; i< a1.length; i++){
      for (int j=0; j< a2.length; j++) {
        if (a1[i] == a2[j]) {
          //we found start of array. continue checking 
          int len = 1;
          while ( ((i+len) < a1.length) 
                 && ((j+len) < a2.length) && (a1[i+len] == a2[j+len])) {
            len++;
          }
          if ( len > subArray.length) {
            System.out.println(i + "--" + len);
            subArray = Arrays.copyOfRange(a1, i, i+len);
          }
        }
      }
    }
    return subArray;
  }
  
}
