/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private Integer prev = null;
    private int diff = Integer.MAX_VALUE;

    public void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);

        if (prev != null) {
            diff = Math.min(diff, root.val - prev);
        }
        prev = root.val;

        inorder(root.right);
    }

    public int getMinimumDifference(TreeNode root) {
        prev = null;
        diff = Integer.MAX_VALUE;
        inorder(root);
        return diff;
    }
}
