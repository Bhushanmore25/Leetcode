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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> li = new ArrayList<Integer>();
        rightview(root, 0,li);
        return li;
    }
    public void rightview(TreeNode root,int level, List<Integer> li)
    {
        if(root==null)
        {
            return;
        }
        if(li.size()==level)
        {
            li.add(root.val);
        }
        rightview(root.right, level+1,li);
        rightview(root.left, level+1,li);

    }
}