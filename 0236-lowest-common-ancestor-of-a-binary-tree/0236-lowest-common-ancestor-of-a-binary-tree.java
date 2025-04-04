/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return left == null ? right : left;
    }
    // public static boolean dfs(TreeNode root,TreeNode target,List<TreeNode> path)
    // {
    //     if(root==null)
    //     {
    //         return false;
    //     }
    //     path.add(root);
    //     if(root.val==target.val)
    //     {
    //         return true;
    //     }
    //     boolean left=dfs(root.left,target,path);
    //     boolean right=dfs(root.right,target,path);
    //     if(left || right) return true;
    //     path.remove(path.size()-1);
    //     return false;
    // }
    // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //     List<TreeNode> path1=new ArrayList<>();
    //     List<TreeNode> path2=new ArrayList<>();
    //     dfs(root,p,path1);
    //     dfs(root,q,path2);
    //     int i=0;
    //     while (i < path1.size() && i < path2.size() && path1.get(i).val == path2.get(i).val) {
    //         i++;
    //     }
    //     return path1.get(i - 1);
    // }
}