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
    public static TreeNode sortingTree(int[] nums,int left,int right)
    {
        if(left>right)
        {
            return null;
        }
        int mid=(left+right)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=sortingTree(nums,left,mid-1);
        root.right=sortingTree(nums,mid+1,right);
        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortingTree(nums,0,nums.length-1);
    }
}