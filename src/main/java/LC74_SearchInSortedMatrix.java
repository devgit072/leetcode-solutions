public class LC74_SearchInSortedMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int x = 0;
        int y = (matrix.length * matrix[0].length) - 1;
        return searchMatrixUtil(matrix, target, x, y, matrix[0].length);
    }

    public static boolean searchMatrixUtil(int[][] matrix, int target, int start, int end, int y_len) {
        if (start > end) {
            return false;
        }
        int mid_index = (start + end + 1) / 2;
        int row_number = mid_index / y_len;
        int col_number = mid_index % y_len;
        if (matrix[row_number][col_number] == target) {
            return true;
        } else if (matrix[row_number][col_number] < target) {
            return searchMatrixUtil(matrix, target, mid_index + 1, end, y_len);
        } else {
            return searchMatrixUtil(matrix, target, start, mid_index - 1, y_len);
        }
    }

    public static void main(String[] args) {

        int[][] matrix1 = new int[][]{
                {1, 4, 7, 12, 15, 1000},
                {2, 5, 19, 31, 32, 1001},
                {3, 8, 24, 33, 35, 1002},
                {40, 41, 42, 44, 45, 1003},
                {99, 100, 103, 106, 128, 1004},
        };
        int[][] matrix = new int[][] {{1,1}};
        System.out.println(searchMatrix(matrix1, 900));
    }
}
