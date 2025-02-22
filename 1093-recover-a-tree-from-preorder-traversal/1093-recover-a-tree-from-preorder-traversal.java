/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    private int i=0;
    public TreeNode recoverFromPreorder(String traversal) {
        
        return buildTree(traversal,0);
    }

    private TreeNode buildTree(String traversal,int depth) {
        int dashes=0;
        while(i + dashes <traversal.length() && traversal.charAt(i + dashes) == '-')
        {
            dashes++;
        }

        if(dashes != depth)
        {
            return null;
        }

        i+=depth;

        final int start=i;
        while(i<traversal.length() && Character.isDigit(traversal.charAt(i)))
        {
            i++;
        }
        return new TreeNode(Integer.valueOf(traversal.substring(start,i)), buildTree(traversal,depth+1),buildTree(traversal,depth+1));
    }
}