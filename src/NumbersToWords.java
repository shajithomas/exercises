import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/*
program to convert numbers to equivalent English words
example:
2341 = two thousand three hundred forty one

 Assumption: n < 1,000,000,000
 */
public class NumbersToWords {
    public NumbersToWords() {
        initialize();
    }

    Map<Integer, String> singles = new HashMap<>();
    Map<Integer, String> doubles = new HashMap<>();

    public String convertToWords(int n) {
        String str = convertToWords(n, 1000000, " million ");
        str += convertToWords(n%1000000, 1000, " thousand ");
        return (str + convertToWords100(n % 1000)).trim();
    }

    private String convertToWords(int n, int base, String baseWord) {
        int quotient = n / base;
        if ( quotient > 0) {
            return convertToWords100(quotient) + baseWord;
        }
        return "";
    }

    public String convertToWords100(int n) {
        String out = new String();

        int quotient = n / 100;
        int remainder = n % 100;
        out += quotient > 0 ? singles.get(quotient) + " hundred " : "";
        if (remainder > 19) {
            quotient = remainder / 10;
            remainder = remainder % 10;
            out += doubles.get(quotient) + " ";
        }
        if (remainder > 0) {
            out += singles.get(remainder);
        }

        return out.trim();

    }

    private void initialize() {
        singles.put(0,"zero");
        singles.put(1,"one");
        singles.put(2,"two");
        singles.put(3,"three");
        singles.put(4,"four");
        singles.put(5,"five");
        singles.put(6,"six");

        singles.put(10, "ten");
        singles.put(11, "eleven");
        singles.put(12,"twelve");
        singles.put(13,"thirteen");
        singles.put(14,"fourteen");
        singles.put(15,"fifteen");

        doubles.put(2, "twenty");
        doubles.put(3, "thirty");
        doubles.put(4, "forty");
        doubles.put(5, "fifty");
    }

    public static class UnitTests {
        NumbersToWords test;

        @Before
        public void init() {
            test = new NumbersToWords();
        }

        @Test
        public void testConvert1s() {
            String words = test.convertToWords(1);
            Assert.assertEquals("one", words);
            Assert.assertEquals("six", test.convertToWords(6));
        }

        @Test
        public void testConvert10s() {
            Assert.assertEquals("ten", test.convertToWords(10));
            Assert.assertEquals("fourteen", test.convertToWords(14));
            Assert.assertEquals("twenty", test.convertToWords(20));
        }

        @Test
        public void testConvert100s() {
            String words = test.convertToWords(155);
            Assert.assertEquals("one hundred fifty five", words);
            Assert.assertEquals("three hundred thirty two", test.convertToWords(332));
        }

        @Test
        public void testConvert1500() {
            String words = test.convertToWords(1500);
            Assert.assertEquals("one thousand five hundred", words);
        }

        @Test
        public void testConvert1524() {
            String words = test.convertToWords(1524);
            Assert.assertEquals("one thousand five hundred twenty four", words);
        }

        @Test
        public void testConvert1514() {
            String words = test.convertToWords(1514);
            Assert.assertEquals("one thousand five hundred fourteen", words);
        }

        @Test
        public void testConvertTenThousands() {
            String words = test.convertToWords(15140);
            Assert.assertEquals("fifteen thousand one hundred forty", words);
            Assert.assertEquals("twenty thousand one hundred forty", test.convertToWords(20140));
        }

        @Test
        public void testConvertHundredThousands() {
            String words = test.convertToWords(150140);
            Assert.assertEquals("one hundred fifty thousand one hundred forty", words);
        }
        @Test
        public void testConvertMillions() {
            String words = test.convertToWords(1500140);
            Assert.assertEquals("one million five hundred thousand one hundred forty", words);
            Assert.assertEquals("four hundred fifty million", test.convertToWords(450000000));
        }

    }
}
