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
    public TreeNode reverseOddLevels(TreeNode root) {
        if(root==null)
            return null;
        TreeNodeReverse(root.left,root.right,1);
        return root;
    }
    public static void TreeNodeReverse(TreeNode leftnode,TreeNode rightnode,int level)
    {
        if(leftnode==null || rightnode==null) return;
        if(level%2==1)
        {
            int temp=leftnode.val;
            leftnode.val=rightnode.val;
            rightnode.val=temp;
        }
        TreeNodeReverse(leftnode.left,rightnode.right,level+1);
        TreeNodeReverse(leftnode.right,rightnode.left,level+1);
    }
}