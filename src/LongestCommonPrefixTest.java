import org.junit.Test;

import static junit.framework.Assert.assertTrue;

public class LongestCommonPrefixTest {
    private LongestCommonPrefix prefix;

    @Test
    public void findLongestCommonPrefixTest(){
        String [] strings = {"Hello", "Help","Helap","Heabcd"};
        prefix = new LongestCommonPrefix();

        String longestPrefix = prefix.findLongestCommonPrefix(strings);
        System.out.println(longestPrefix);
        assertTrue(longestPrefix.equals("He"));
    }

}
