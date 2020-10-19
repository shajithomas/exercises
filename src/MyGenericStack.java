/*
 A generic stack implementation
 */
import org.junit.Assert;
import org.junit.Test;

public class MyGenericStack<T> {
    T[] data = (T[])new Object[20000];
    int pos = 0;

    public void push(T c) {
        data[pos++] = c;
    }

    public T pop() {
        if (pos <= 0) {
            return null;
        } else {
            return data[--pos];
        }
    }

    public static class UnitTest {
        @Test
        public void testCharacter() {
            MyGenericStack<Character> stack = new MyGenericStack<Character>();
            stack.push('a');
            stack.push('b');

            Assert.assertTrue(stack.pop().equals('b'));
            Assert.assertTrue(stack.pop().equals('a'));
        }

        @Test
        public void testInteger() {
            MyGenericStack<Integer> stack = new MyGenericStack<>();
            stack.push(5);
            stack.push(100);

            Assert.assertTrue(stack.pop().equals(100));
            Assert.assertTrue(stack.pop().equals(5));
        }

    }
}
