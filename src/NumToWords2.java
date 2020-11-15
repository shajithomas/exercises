/*
program to convert numbers to equivalent English words
example:
2341 = two thousand three hundred forty one

Assumption: n < 1,000,000,000
*/

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NumToWords2 {
    String ones[] = {"", "one ", "two ", "three ", "four ",
            "five ", "six ", "seven ", "eight ",
            "nine ", "ten ", "eleven ", "twelve ",
            "thirteen ", "fourteen ", "fifteen ",
            "sixteen ", "seventeen ", "eighteen ",
            "nineteen " };

    String tens[] = { "", "", "twenty ", "thirty ", "forty ",
            "fifty ", "sixty ", "seventy ", "eighty ",
            "ninety " };

    public String numToWords100(int n, String base) {
        String str = "";
        if ( n > 19) {
            str += tens[n/10] + ones[n%10];
        } else if (n > 0 ){
            str += ones[n];
        }
        if ( n > 0) {
            str += base;
        }
        return str;
    }

    public String numToWords(int n) {
        String str = "";
        str += numToWords100(n/1000000000, "billion ");
        str += numToWords100((n%1000000000)/1000000, "million ");
        str+= numToWords100((n%1000000)/1000, "thousand ");
        str += numToWords100((n%1000)/100, "hundred ");
        str += numToWords100(n%100, "");
        return str.trim();
    }

    public static class UnitTest{
        NumToWords2 test;

        @Before
        public void init() {
            test = new NumToWords2();
        }
        @Test
        public void test100s() {
            Assert.assertEquals("twenty four", test.numToWords(24));
            Assert.assertEquals("ninety nine", test.numToWords(99));
        }

        @Test
        public void testLessThan20(){
            Assert.assertEquals("ten", test.numToWords(10));
            Assert.assertEquals("one", test.numToWords(1));
        }

        @Test
        public void testGreaterThan100s() {
            Assert.assertEquals("one hundred", test.numToWords(100));
            Assert.assertEquals("one hundred twenty three", test.numToWords(123));
            Assert.assertEquals("nine hundred ninety nine", test.numToWords(999));
            Assert.assertEquals("one thousand", test.numToWords(1000));
            Assert.assertEquals("nine thousand ninety nine", test.numToWords(9099));
            Assert.assertEquals("one million", test.numToWords(1000000));
            Assert.assertEquals("one million ten", test.numToWords(1000010));
            Assert.assertEquals("one billion", test.numToWords(1000000000));
        }

    }
}
