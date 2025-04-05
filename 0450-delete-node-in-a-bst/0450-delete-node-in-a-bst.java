class Solution {
    public static int findMax(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left; 
            } else {
                int maxVal = findMax(root.left);
                root.val = maxVal;
                root.left = deleteNode(root.left, maxVal);
            }
        }
        return root;
    }
}
