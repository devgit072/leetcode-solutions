import java.util.Stack;

public class LC11_MaximumWaterContainer {
    public static int maxArea(int[] height) {
        int leftPtr = 0, rightPtr = height.length - 1;
        int maximum = 0;
        while(leftPtr < rightPtr) {
            int indexDiff = rightPtr - leftPtr;
            int area = Integer.min(height[leftPtr], height[rightPtr]) * indexDiff;
            if(area > maximum) {
                maximum = area;
            }
            if(height[leftPtr] > height[rightPtr]) {
                rightPtr--;
            } else if(height[leftPtr] < height[rightPtr]) {
                leftPtr++;
            } else {
                leftPtr++;
                rightPtr--;
            }
        }
        return maximum;
    }

    public static void main(String[] args) {
        int[] heights1 = new int[]{1, 8, 4, 2, 3, 2, 5, 6, 80, 90};
        int[] heights = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(heights));
    }
}
