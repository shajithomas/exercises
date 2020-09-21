import org.junit.Assert;
import org.junit.Test;

public class MinSwaps {

    static int minimumSwaps(int[] arr) {
            if ( arr == null || arr.length < 2) {
                return 0;
            }
            int[] swapCount = {0};
            int low = 0;
            int high = arr.length-1;
            qsort ( arr, low, high, swapCount);
            return swapCount[0];
        }

        private static void qsort(int[] values, int lo, int hi, int[] swapCount) {
            int i = lo;
            int j = hi;
            int pivotIndex = (lo + hi)/2;
            int pivot = values[pivotIndex];

            while ( i <= j ) {
                while( values[i] < pivot ) i++;
                while( values[j] > pivot ) j--;
                if ( i <= j ) {
                    if ( i < j) {
                        swap(values, i, j);
                        swapCount[0]++;
                    }
                    i++;
                    j--;
                }
            }

            if ( lo < j ){
                qsort (values, lo,j, swapCount);
            }
            if ( i < hi ) {
                qsort(values, i, hi, swapCount);
            }
        }

        private static void swap(int[] values, int a, int b) {
            int temp = values[a];
            values[a] = values[b];
            values[b] = temp;
        }

        public static class UnitTests {
            @Test
            public void testMinSwap() {
                int[] array = { 1, 3, 5, 2, 4, 6, 7};
                MinSwaps minSwaps = new MinSwaps();
                int result = minSwaps.minimumSwaps(array);
                Assert.assertEquals(3,result );
            }

            @Test
            public void testMinSwap2() {
                int[] array = { 7, 1, 3, 2, 4, 5, 6};
                MinSwaps minSwaps = new MinSwaps();
                int result = minSwaps.minimumSwaps(array);
                Assert.assertEquals(5,result );
            }
        }

    }
