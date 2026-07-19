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
    int count=0;
    public int dfs(TreeNode root)
    {
        if (root == null)
            return Integer.MIN_VALUE;
        if(root.left==null && root.right==null)
        {
            count++;
            return root.val;
        }
        int left=-1,right=-1;
        if(root.left!=null)
            left=dfs(root.left);
        if(root.right!=null)
            right=dfs(root.right);
        int max=Math.max(root.val,Math.max(left,right));
        if(max == root.val) count++;
        return max;
    }
    public int countDominantNodes(TreeNode root) {
        count=0;
        if(root==null) return count;
        dfs(root);
        return count;
    }
}