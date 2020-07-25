import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class TowersOfHanoi {
  public static void main(String[] args) {
    towersOfHanoi(4, "src", "dest", "aux");
  }
  public static void towersOfHanoi(int discs, String src, String dest, String aux) {
    if ( discs == 1 ) { 
    // move it to dest
      System.out.println("moving disc 1 from " + src + " to " + dest);
    } else {
       towersOfHanoi(discs-1, src, aux, dest);
       System.out.println("moved disc " + discs + " from "+ src + " to " + dest );
       towersOfHanoi(discs-1, aux, dest, src);
    }
  }
}