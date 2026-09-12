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
    public int count;
    public int[] findVal(TreeNode root)
    {
        if(root==null) return new int[]{0,0};
        if(root.left==null && root.right==null)
        {
            count++;
            return new int[]{root.val,1};
        }
        int sum=root.val,c=1;
        if(root.left!=null)
        {
            int[] t=findVal(root.left);
            sum+=t[0];
            c+=t[1];
        }
        if(root.right!=null)
        {
            int[] t=findVal(root.right);
            sum+=t[0];
            c+=t[1];
        }
        int avg=sum/c;
        if(avg==root.val) count++;
        return new int[]{sum,c};
    }
    public int averageOfSubtree(TreeNode root) {
        findVal(root);
        return count;
    }
}