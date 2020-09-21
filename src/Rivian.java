
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class Rivian {

    /*
       This is assuming that we start from the beginning of the string of moves each time.
     * Complete the 'distinctMoves' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER n
     *  3. INTEGER x
     *  4. INTEGER y
     */
    public static int distinctMoves(String s, int n, int x, int y) {
        // Write your code here
        Map<String, Integer> path = new LinkedHashMap<>();
        Integer curPoint = x;
        int i = 0;
        while (i < s.length() && (curPoint < n && curPoint >= 0)) {
            if (s.charAt(i) == 'r' && curPoint < n) {
                curPoint++;
            } else if (s.charAt(i) == 'l' && curPoint > 0) {
                curPoint--;
            }
            i++;
            if (curPoint == y) {
                String curPath = s.substring(0, i);
                if (path.get(curPath) == null) {
                    path.put(curPath, 1);
                    i = 0;
                    curPoint = x;
                }
            }
        }
        System.out.println(path.size());
        return path.size();
    }


    public static class UnitTests {
        @Test
        public void test() {
            String moves = "rrlrlr";
            int n = 6;
            int x = 1;
            int y = 2;
            int result = Rivian.distinctMoves(moves, 6, 1, 2);
            int expected = 3;
            System.out.println(result);
            Assert.assertEquals(expected, result);
        }

        @Test
        public void test2() {
            String moves = "rrlrlrrll";
            int n = 6;
            int x = 1;
            int y = 2;
            // r
            // rrl
            // rrlrl
            // rrlrlrrll
            int result = Rivian.distinctMoves(moves, 10, 1, 2);
            int expected = 4;
            System.out.println(result);
            Assert.assertEquals(expected, result);
        }
    }

}
