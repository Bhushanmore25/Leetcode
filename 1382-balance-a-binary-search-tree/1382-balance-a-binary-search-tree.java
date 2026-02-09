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
    public static void inorder(TreeNode root,List<Integer> li)
    {
        if(root== null) return;
        inorder(root.left,li);
        li.add(root.val);
        inorder(root.right,li);
    }
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> li=new ArrayList<>();
        inorder(root,li);
        root=createBST(li,0,li.size()-1);
        return root;
    }
    public static TreeNode createBST(List<Integer> li,int st,int end)
    {
        if(st>end) return null;
        int mid=(st+end)/2;
        TreeNode curr=new TreeNode(li.get(mid));
        curr.left=createBST(li,st,mid-1);
        curr.right=createBST(li,mid+1,end);
        return curr;
    }
}