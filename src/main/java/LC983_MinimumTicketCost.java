import java.util.Arrays;

public class LC983_MinimumTicketCost {

    /*
       Normal unoptimized solution.
     */
    static int minimumCost(int[] arr, int[] costs, int[] daysPassArr, int currIndex) {
        if (currIndex >= arr.length) {
            return 0;
        }
        int currDay = arr[currIndex];
        int i = currIndex;

        int min = Integer.MAX_VALUE;
        for(int k=0; k< daysPassArr.length;k++) {
            int cost = 0;
            while(i < arr.length && arr[i] < currDay + daysPassArr[k]) {
                i++;
            }
            cost += costs[k];
            cost += minimumCost(arr, costs, daysPassArr, i);
            min = Math.min(min, cost);
        }
        return min;
    }

    static int minimumCostDP(int[] arr, int[] costs, int[] daysPassArr, int currIndex, int[] memo) {
        if (currIndex >= arr.length) {
            return 0;
        }

        if(memo[currIndex] != -1) {
            return memo[currIndex];
        }
        int currDay = arr[currIndex];
        int i = currIndex;

        int min = Integer.MAX_VALUE;
        for(int k=0; k< daysPassArr.length;k++) {
            int cost = 0;
            while(i < arr.length && arr[i] < currDay + daysPassArr[k]) {
                i++;
            }
            cost += costs[k];
            cost += minimumCostDP(arr, costs, daysPassArr, i, memo);
            min = Math.min(min, cost);
        }
        memo[currIndex] = min;
        return min;
    }

    public static void main(String[] args) {
        int[] days = new int[] {1,2,3,4,5,6,7,8,9,10,30,31};
        int[] daysPassArr = new int[] {1,7,30};
        int[] costs = new int[] {2,7,15};
        int[] memo = new int[days.length];
        Arrays.fill(memo, -1);
        System.out.println(minimumCostDP(days, costs, daysPassArr, 0, memo));
    }
}
