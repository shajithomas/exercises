/*
* remove duplicates from a sorted array.
* Alternatively, given an unsorted array, first sort and use the same algo
*/
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class RemoveDuplicate {
    public static void main(String [] args) {
        RemoveDuplicate test = new RemoveDuplicate();
        int[] arr = {0,0,1,1,1,2,3,4};
        int[] out = test.removeDupe2(arr);
        System.out.println(Arrays.toString(out));
    }

    //wrong one. arraycopy hangs
    public int removeDuplicates(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == nums[i + 1]) {
                System.arraycopy(nums, i + 1, nums, i, nums.length - 1 - i);
                System.out.println(Arrays.toString(nums));
            } else {
                i++;
            }
        }
        return nums.length;
    }

    public int[] removeDupe2(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
        }
        //remove the last elements which are still there.
        int[] out = Arrays.copyOf(nums, i + 1);
        return out;
    }

    public int[] removeDupe3(int[] nums) {
        int i = 0;
        int j = 1;
        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                j++;
            } else {
                nums[++i] = nums[j++];
            }
        }
        int[] out = Arrays.copyOf(nums, i+1);
        return out;
    }

    public static class UnitTest{
        @Test
        public void testRemoveDupe3() {
            RemoveDuplicate test = new RemoveDuplicate();
            int[] arr = {0,0,1,1,1,2,3,4};
            int[] expected = {0, 1, 2, 3, 4};
            int[] result  = test.removeDupe3(arr);
            System.out.println(Arrays.toString(result));
            Assert.assertArrayEquals(expected, result);
        }

        @Test
        public void testRemoveDupe2() {
            RemoveDuplicate test = new RemoveDuplicate();
            int[] arr = {0,0,1,1,1,2,3,4};
            int[] expected = {0, 1, 2, 3, 4};
            int[] result  = test.removeDupe2(arr);
            System.out.println(Arrays.toString(result));
            Assert.assertArrayEquals(expected, result);
        }

    }
}
