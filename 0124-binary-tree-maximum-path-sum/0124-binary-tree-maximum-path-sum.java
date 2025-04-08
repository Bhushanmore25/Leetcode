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
    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return ans;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int leftSum = helper(root.left);
        int rightSum = helper(root.right);
        
        if (leftSum < 0) leftSum = 0;
        if (rightSum < 0) rightSum = 0;
        
        ans = Math.max(ans, leftSum + rightSum + root.val);
    
        return root.val + Math.max(leftSum, rightSum);
    }
}
// class Solution {
//     static class Info {
//         int dia;
//         int ht; 

//         public Info(int dia, int ht) {
//             this.dia = dia;
//             this.ht = ht;
//         }
//     }

//     public static Info maxPath(TreeNode root) {
//         if (root == null) return new Info(Integer.MIN_VALUE, 0);

//         Info left = maxPath(root.left);
//         Info right = maxPath(root.right);
//         int throughRoot = root.val + Math.max(0, left.ht) + Math.max(0, right.ht);
//         int singlePath = root.val + Math.max(0, Math.max(left.ht, right.ht));
//         int dia = Math.max(throughRoot, Math.max(left.dia, right.dia));

//         return new Info(dia, singlePath);
//     }

//     public int maxPathSum(TreeNode root) {
//         Info ans = maxPath(root);
//         return ans.dia;
//     }
// }