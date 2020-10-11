/*

A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.

For example, number 9 has binary representation 1001 and contains a binary gap of length 2. The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3. The number 20 has binary representation 10100 and contains one binary gap of length 1. The number 15 has binary representation 1111 and has no binary gaps. The number 32 has binary representation 100000 and has no binary gaps.

Write a function:

class Solution { public int solution(int N); }

that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.

For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of length 5. Given N = 32 the function should return 0, because N has binary representation '100000' and thus no binary gaps.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..2,147,483,647].
Copyright 2009–2020 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.

 */

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

class BinaryGap {

    public static void main(String[] args) {
        BinaryGap bg = new BinaryGap();
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        while (num != -1) {
            System.out.println("\nEnter the number to find the gap");
            num = scanner.nextInt();
            if (num == -1 ) {
                return;
            }
            int gap = bg.findBinaryGap(num);
            System.out.println("The gap is : " + gap);
        }
    }
    public int findBinaryGap(int N) {
        int[] result = new int[32];

        // convert number to binary number
        int R;
        int i = 0;
        while ( N >= 1) {
            R = N % 2;
            N = N / 2;
            result[i] = R;
            i++;
        }

        int[] gaps = new int[i];
        i--;

        for (int k=i; k >= 0; k--) {
            System.out.print(result[k] + " ");
        }
        System.out.println();

        boolean start_gap = false;
        int gapNo = 0;
        int startIndex = 0;
        while ( i >= 0) {
            if (result[i] == 1) {
                if (!start_gap) {
                    start_gap = true;
                } else {
                    gaps[gapNo] = startIndex - i-1;
                    gapNo++;
                }
                startIndex = i;
            }
            i--;
        }
        int maxGap = Arrays.stream(gaps).max().getAsInt();
        return maxGap;
    }

    public static class UnitTest{
        @Test
        public void testGap() {
            BinaryGap bg = new BinaryGap();
            int gap = bg.findBinaryGap(17);
            // 17 = 10001
            Assert.assertEquals(3, gap);
            gap = bg.findBinaryGap(5);
            // 5 = 101
            Assert.assertEquals(1, gap);
            Assert.assertEquals(0, bg.findBinaryGap(3)); //11
            Assert.assertEquals(1, bg.findBinaryGap(45)); //1 0 1 1 0 1

        }
    }

}


/*
N

5%2 = 2 R 1
2%2 = 1 R 0
1%2 = 0 R 1

4%2 = 2 R 0
2%2 = 1 R 0
1%2 = 0 R 1

100100

*/


