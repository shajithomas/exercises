
public class Fibonacci {

    /* Find the nth Fibonacci number */
    int findNthFibo(int n) {
        if (n == 1) {
            return 0;
        }
        int fib1 = 0;
        int fib2 = 1;
        for (int i=3; i<=n; i++) {
            int temp = fib2;
            fib2 = fib1 + fib2;
            fib1 = temp;
        }
        return fib2;
    }

    int fiboRecursive(int n) {
        if (n==1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        return fiboRecursive(n-1) + fiboRecursive(n-2);
    }

    /*
     * classic dynamic with memoization using a cache array
     */
    int fiboDynamic(int n) {
        int[] cache = new int[n+1]; // +1 b/c fib 1 will only have space for 1 if n
        cache[0] = 0;
        cache[1] = 1;
        return calcFibo(n,cache);
    }

    int calcFibo(int n, int[] cache) {
            if (cache[n-1] != 0 || n < 2) {
                return cache[n - 1];
            }
        cache[n-1] = calcFibo(n-1, cache) + calcFibo(n-2, cache);
        return cache[n-1];

    }
}
//    for Unit tests see the class FibonacciTest
