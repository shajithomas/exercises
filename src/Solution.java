import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  static volatile boolean quit = false;
  public static void main(String[] args) throws Exception{
    Thread t = new Thread (() -> {
      int i = 0;
      while (i < 1000 && quit != true) {
        System.out.println("running thread..... " + i + "  quit=" + quit);
        i++;
      }
    });
    t.start();
    Thread.sleep(10);
    quit = true;
  }
}

