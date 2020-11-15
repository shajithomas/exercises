import java.util.ArrayList;
import java.util.List;

/*
1 3 5 7
15
*/
public class SubsetSum {

    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7, 9};
        int target = 15;
        List<Integer> out = new ArrayList<>();
        findSumNumbers(a, 0, target, out);
        System.out.println(result);
    }

    public static void findSumNumbers(int[] a, int index, int target, List<Integer> out) {
        if (target == 0) {
            result = List.copyOf(out);
            return;
        }
        if (index >= a.length || target < 0) {
            return;
        }
        out.add(a[index]);
        findSumNumbers(a, index + 1, target - a[index], out);
        out.remove(out.size()-1);
        System.out.println("target=" + target + "  index=" + index + "  a=" + a[index]);
        findSumNumbers(a, index + 1, target, out);
    }
}
