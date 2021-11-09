import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC46_Permutation {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int n : nums) {
            list.add(n);
        }
        return getPermutations(list);
    }
    public static List<List<Integer>> getPermutations(List<Integer> array) {
        if(array.isEmpty()) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        permuteBackTrack(array.size(), 0, array, result);
        return result;
    }

    public static void permuteBackTrack(int n, int currIndex, List<Integer> array, List<List<Integer>> result) {
        if(currIndex == n) {
            result.add(new ArrayList<>(array));
        }
        for(int i=currIndex;i<n;i++) {
            swap(array, currIndex, i);
            permuteBackTrack(n, currIndex+1, array, result);
            // Backtrack it to original array.
            swap(array, currIndex, i);
        }
    }

    private static void swap(List<Integer> array, int i, int j) {
        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }
}
