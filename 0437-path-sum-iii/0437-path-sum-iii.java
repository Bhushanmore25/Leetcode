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
    private int res = 0;
    public int pathSum(TreeNode root, int target) {
        helper(root, (long)target, true);
        return res;
    }

    private void helper(TreeNode root, long target, boolean isHead) {
        if(root == null) return;
        if(root.val == target) res++;
        if(isHead) {
            helper(root.left, target, true);
            helper(root.right, target, true);
        }
        helper(root.left, target - root.val, false);
        helper(root.right, target - root.val, false);
    }
}