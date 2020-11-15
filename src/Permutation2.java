import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Permutation2 {
    List<String> permutations = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner( System.in);
        System.out.println("Enter the string for Permutation");
        String s = scanner.next();
        Permutation2 perm = new Permutation2();
        perm.permute(s);
    }
    public List<String> permute(String s){
        doPermute(s, 0, s.length()-1);
        return permutations;
    }
    public void doPermute(String s, int left, int right) {
        if (left == right) {
            System.out.println(s);
            permutations.add(s);
        } else {
            for (int i = left; i <= right; i++) {
                String swapped = swap(s, left, i);
//                System.out.println("after swap ---:" +swapped + " left = " + left + " i = " + i);
                doPermute(swapped, left+1, right);
            }
        }

    }

    private String swap(String str, int i, int j) {
        char[] s = str.toCharArray();
        char temp = s[j];
        s[j] = s[i];
        s[i] = temp;
        return String.valueOf(s);
    }

    public static class UnitTests {
        @Test
        public void testPermute() {
            String str = "ABC";
            List<String> expected = Arrays.asList("ABC", "ACB", "BAC", "BCA", "CBA", "CAB");
            Permutation2 perm = new Permutation2();
            List<String> result = perm.permute(str);
            expected.sort(null);
            result.sort(null);
            Assert.assertEquals(expected, result);
        }
    }
}
