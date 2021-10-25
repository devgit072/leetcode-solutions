public class LC167_TwoSumSortedArray {
    public static int[] twoSum(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length -1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if(sum == target) {
                return new int[] {low+1, high+1};
            } else if(sum > target) {
                    high--;
            } else {
                low++;
            }
        }
        return new int[] {-1, -1};
    }

    public static int[] twoSumUsingBinarySearch(int[] numbers, int target) {
        for(int i =0;i<numbers.length;i++) {
            int value = numbers[i];
            int diff = target - value;
            if(diff >= value) {
                int index = findElement(numbers, diff, i+1, numbers.length);
                if(index != -1) {
                    return new int[] {i+1, index+1};
                }
            }
            if(diff <= value) {
                int index = findElement(numbers, diff, 0, i-1);
                if(index != -1) {
                    return new int[] {index+1, i+1};
                }
            }
        }
        return new int[] {-1, -1};
    }

    private static int findElement(int[] numbers, int val, int low, int high) {
        if(low < 0 || high >= numbers.length || low > high ){
            return -1;
        }

        int midIndex = (low + high + 1) / 2;
        if(numbers[midIndex] == val) {
            return midIndex;
        }
        if(numbers[midIndex] > val) {
            return findElement(numbers, val, low, midIndex -1);
        } else {
            return findElement(numbers, val, midIndex+1, high);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int target = 17;
        int[] res = twoSum(nums, target);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}
