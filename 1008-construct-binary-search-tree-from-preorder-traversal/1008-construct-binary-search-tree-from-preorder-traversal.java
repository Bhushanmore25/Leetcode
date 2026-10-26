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
    public TreeNode addNode(int val,TreeNode root){
        if(root==null) return new TreeNode(val);
        if(root.val<val) root.right=addNode(val,root.right); 
        if(root.val>val) root.left=addNode(val,root.left);
        return root; 
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder.length==0) return new TreeNode();
        TreeNode root= addNode(preorder[0],null);
        for(int i=1;i<preorder.length;i++){
            addNode(preorder[i],root);
        }
        return root;
    }
}