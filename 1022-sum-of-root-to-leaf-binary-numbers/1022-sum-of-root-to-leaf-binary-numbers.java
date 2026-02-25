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
    public static int recursion(TreeNode root,int value)
    {
        if (root == null) return 0;
        value = (value << 1) | root.val;
        if(root.left==null && root.right==null) {
            return value;
        }
        return recursion(root.right,value) + recursion(root.left,value); 

    }
    public int sumRootToLeaf(TreeNode root) {
        if(root==null) return 0;
        return recursion(root,0);
    }
}