import org.junit.Assert;
import org.junit.Test;

public class MatchingBracketsTest {
    @Test
    public void matchingBrackets() {
        MatchingBrackets test = new MatchingBrackets();
        String brackets = "{[()()]}";
        int result = test.matchingBrackets2(brackets);
        System.out.println(result);
        Assert.assertEquals(1, result);
    }

    @Test
    public void matchingBracketsInvalid() {
        MatchingBrackets test = new MatchingBrackets();
        String brackets = "([)()]";
        int result = test.matchingBrackets2(brackets);
        System.out.println(result);
        Assert.assertEquals(0, result);
    }

    @Test
    public void matchingBracketsInvalid2() {
        MatchingBrackets test = new MatchingBrackets();
        String brackets = "{[()()]}";
        int result = test.matchingBrackets2(brackets);
        System.out.println(result);
        Assert.assertEquals(1, result);
    }
}

