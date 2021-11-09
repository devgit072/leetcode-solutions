public class LC129_SumFromRootToLeaf {
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

    int globalSum = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if(isLeafNode(root)) {
            return root.val;
        }
        sumNumbersUtil(root.left, root.val+"");
        sumNumbersUtil(root.right, root.val+"");
        return globalSum;
    }

    public void sumNumbersUtil(TreeNode node, String val) {
        if (node == null) {
            return;
        }
        if (isLeafNode(node)) {
            int leafNodeValue = node.val;
            String finalValue = val + leafNodeValue;
            int finalValueInt = Integer.parseInt(finalValue);
            globalSum += finalValueInt;
            return;
        }
        if (node.left != null) {
            sumNumbersUtil(node.left, val + node.val);
        }
        if (node.right != null) {
            sumNumbersUtil(node.right, val + node.val);
        }
    }

    private boolean isLeafNode(TreeNode node) {
        if (node.left == null && node.right == null) {
            return true;
        }
        return false;
    }

}
