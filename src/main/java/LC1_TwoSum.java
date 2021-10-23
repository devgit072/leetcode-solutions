import java.util.HashMap;
import java.util.Map;

public class LC1_TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for(int i=0;i<nums.length;i++) {
            int value = nums[i];
            int diff = target - value;
            if(map.containsKey(diff)) {
                if(map.get(diff) != i) {
                    return new int[] {i, map.get(diff)};
                }
            }
        }
        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        System.out.println(twoSum(nums, target)[0]);
        System.out.println(twoSum(nums, target)[1]);
    }
}
