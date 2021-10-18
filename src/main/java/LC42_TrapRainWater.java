/*
    This is pretty hard question but a beautiful one. Hence I will put
    lots of comment for better understanding.

 */
public class LC42_TrapRainWater {

    // Bruteforce solution.
    /*
    In bruteforce solution, we will calculate water at every index. The one thing to note that the first and last index
    will not store any water, hence we will start water calculation from index=1 to index=last-1
    If array just contains 2 elements, so water stored will 0.
    WaterStoredAtGivenIndex = WaterLevel - HeightOfBlockAtGivenIndex
    Now, how do we calculate WaterLevel for given index? The water-level will be minimum of left_max and right_max.
    For every index i, we go to left side from i-1 and find the maximum block height. Similarly, we for we go right from
    i+1 and find the maximum bloc height. WaterLevel will be mimimum of (left_max, right_max).
    We calculate waterStored for every index from 1 to last-1 and add the sum.
    One thing to note that, current block height must be greater than left_max and right_max, else water can't be stored.
     */
    public static int trap(int[] height) {
        int waterStored = 0;
        // Calculate water at every index.
        for (int i = 1; i <= height.length - 2; i++) {
            // for index i, find left_max.
            int leftPtr = i - 1;
            int leftMax = Integer.MIN_VALUE;
            while (leftPtr >= 0) {
                if (height[leftPtr] > leftMax) {
                    leftMax = height[leftPtr];
                }
                leftPtr--;
            }
            int rightPtr = i + 1;
            int rightMax = Integer.MIN_VALUE;
            while (rightPtr <= height.length -1) {
                if (height[rightPtr] > rightMax) {
                    rightMax = height[rightPtr];
                }
                rightPtr++;
            }
            int waterLevel = Integer.min(leftMax, rightMax);
            int waterAtGivenIndex = 0;
            if(height[i] < waterLevel) {
                waterAtGivenIndex = waterLevel - height[i];
                waterStored += waterAtGivenIndex;
            }
        }
        return waterStored;
    }

    /*
    This is becoming O(n^2) because for every index, we have to find left_max and right_max.
    So we can pre-compute the left_max and right_max and store it in array.
    So array leftMaxArray[] will tell that for given index i, the left_max is leftMaxArray[i].
    Same with rightMaxArray.
     */
    public static int trap_optimised(int[] height) {
        int waterStored = 0;
        int len = height.length;
        // Pre-compute leftMaxArry and rightMaxArray
        int[] leftMaxArr = new int[len];
        int[] rightMaxArr = new int[len];
        leftMaxArr[0]=height[0];
        rightMaxArr[len-1]=height[len-1];
        for(int i=1;i<=height.length-1;i++) {
            leftMaxArr[i] = Math.max(height[i], leftMaxArr[i - 1]);
        }
        for(int i=len-2;i >= 0;i--) {
            rightMaxArr[i] = Math.max(height[i], rightMaxArr[i + 1]);
        }
        // Calculate water at every index.
        for (int i = 1; i <= height.length - 2; i++) {
            int leftMax = leftMaxArr[i-1];
            int rightMax = rightMaxArr[i+1];
            int waterLevel = Integer.min(leftMax, rightMax);
            if(height[i] < waterLevel) {
                int waterAtGivenIndex = waterLevel - height[i];
                waterStored += waterAtGivenIndex;
            }
        }
        return waterStored;
    }

    public static void main(String[] args) {
        int[] height = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
        //int[] height = new int[] {4,2,0,3,2,5};
        System.out.println(trap_optimised(height));
    }
}
