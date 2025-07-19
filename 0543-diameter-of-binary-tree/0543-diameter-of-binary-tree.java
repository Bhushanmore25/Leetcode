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
    public int maxi=0;
    public int height(TreeNode root)
    {
        if(root==null) return 0;
        int lh=height(root.left);
        int rh=height(root.right);
        maxi=Math.max(maxi,lh+rh);
        return 1 + Math.max(lh,rh);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        maxi = 0; 
        height(root);
        return maxi;
    }
}