import java.util.function.Function;
import java.util.function.UnaryOperator;

/*
 * write a lamda expression to reverse a string
 */
public class LamdaTests {
    interface StringFunc {
        String run(String s);
    }

    public static void main(String[] args) {

        StringFunc rev = (String s) -> {
            char[] str = s.toCharArray();
            int start = 0;
            int end = str.length - 1;
            while (start < end) {
                char temp = str[start];
                str[start] = str[end];
                str[end] = temp;
                start++;
                end--;
            }
            return new String(str);
        };

        //lamda
        StringFunc upper = (String s) -> {
            return s.toUpperCase();
        };

        //using method reference
        StringFunc lower = String::toLowerCase;

        //using an anonymous class
        StringFunc lower2 = new StringFunc() {
            @Override
            public String run(String s) {
                return s.toLowerCase();
            }
        };


        //Using an existing java Functional interface
        Function<String, String> op = (String s) -> s.toUpperCase();

        System.out.println(rev.run("abcd"));
        System.out.println(upper.run("name"));
        System.out.println(lower.run("LAST NAME"));
        System.out.println(lower2.run("Last Name"));

        System.out.println( op.apply("shaji"));
    }
}
