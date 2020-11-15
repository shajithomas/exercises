import org.junit.Assert;
import org.junit.Test;

public class FibonacciTest {

    @Test
    public void find5thFibo() {
        Fibonacci fib = new Fibonacci();
        int result = fib.findNthFibo(5);
        int expected = 3; //0,1,1,2,3
        Assert.assertEquals(expected, result);
        Assert.assertEquals(expected, fib.fiboRecursive(5));
        Assert.assertEquals(expected, fib.fiboDynamic(5));

    }
    @Test
    public void find10thFibo() {
        Fibonacci fib = new Fibonacci();
        int expected = 34; //0,1,1,2,3,5,8,13,21,34
        int result = fib.findNthFibo(10);
        Assert.assertEquals(expected, result);
        Assert.assertEquals(expected, fib.fiboRecursive(10));
        Assert.assertEquals(expected, fib.fiboDynamic(10));
    }

    @Test
    public void find1stFibo() {
        Fibonacci fib = new Fibonacci();
        int result = fib.findNthFibo(1);
        System.out.println(result);
        int expected = 0;
        Assert.assertEquals(expected, result);
        Assert.assertEquals(expected, fib.fiboRecursive(1));
        Assert.assertEquals(expected, fib.fiboDynamic(1));

    }

    @Test
    public void testFib1() {
        Fibonacci fib = new Fibonacci();
        Assert.assertEquals(1, fib.findNthFibo(3));
        Assert.assertEquals(2, fib.findNthFibo(4));
        Assert.assertEquals(3, fib.findNthFibo(5));
        Assert.assertEquals(5, fib.findNthFibo(6));
    }

    @Test
    public void testFibRecursive() {
        Fibonacci fib = new Fibonacci();
        Assert.assertEquals(1, fib.fiboRecursive(3));
        Assert.assertEquals(2, fib.fiboRecursive(4));
        Assert.assertEquals(3, fib.fiboRecursive(5));
        Assert.assertEquals(5, fib.fiboRecursive(6));
    }

    @Test
    public void testFibDynamic() {
        Fibonacci fib = new Fibonacci();
        Assert.assertEquals(1, fib.fiboDynamic(3));
        Assert.assertEquals(2, fib.fiboDynamic(4));
        Assert.assertEquals(3, fib.fiboDynamic(5));
        Assert.assertEquals(5, fib.fiboDynamic(6));
    }


}