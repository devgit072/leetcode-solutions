public class LC98_IsValidBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static boolean isValidBST(TreeNode root) {
        return validateBstUtil(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean validateBstUtil(TreeNode tree, long min, long max) {
        if (tree == null) {
            return true;
        }
        if (tree.val <= min || tree.val >= max) {
            return false;
        }
        /*
        The logic is hard to understand, but here is explain.
        Each tree node tells its left child that you need to be between the minimum value I got from parent and my value
        i.e (min, tree.value)
        Similarly each tree node tells its right child that you need to be between my value and maximum value I got from parent and my value
        i.e (tree.value, maximum)
         */
        return validateBstUtil(tree.left, min, tree.val) && validateBstUtil(tree.right, tree.val, max);
    }
}
