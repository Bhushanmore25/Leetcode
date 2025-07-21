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
    public void flatten(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            // If the current node has a left child
            if (current.left != null) {
                // Find the rightmost node of the left subtree (predecessor)
                TreeNode temp = current.left;
                while (temp.right != null) {
                    temp = temp.right;
                }
                
                // Rewire the pointers
                temp.right = current.right;      // Attach original right subtree to the predecessor's right
                current.right = current.left;    // Move left subtree to the right side
                current.left = null;             // Set left child to null
            }
            // Move to the next node in the flattened list
            current = current.right;
        }
    }
}