import java.util.Arrays;

public class RemoveDuplicate {
    public static void main(String [] args) {
        RemoveDuplicate test = new RemoveDuplicate();
        int[] arr = {0,0,1,1,1,2,3,4};
        int len = test.removeDupe2(arr);
        System.out.println(len);
    }

    //wrong one. arraycopy hangs
    public int removeDuplicates(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == nums[i + 1]) {
                System.arraycopy(nums, i + 1, nums, i, nums.length - 1 - i);
                System.out.println(nums);
            } else {
                i++;
            }
        }
        return nums.length;
    }
    public int removeDupe2(int[] nums) {
        int i = 0;
        for ( int j = 1; j < nums.length; j++){
            if (nums[i] == nums[j]){
                continue;
            } else {
                i++;
                nums[i] = nums[j];
            }
        }
        //this prints the whole array including the last elements which are still there.
        System.out.println(Arrays.toString(nums));
        return i+1;
    }
}