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
    public int maxLevelSum(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> q=new LinkedList<>();
        int maxi[]=new int[]{1,root.val};
        q.add(root);
        int lvl=1;
        while(!q.isEmpty())
        {
            int size=q.size();
            int total=0;
            for(int i=0;i<size;i++)
            {
                TreeNode curr=q.poll();
                total+=curr.val;
                if(curr.left!=null)
                    q.add(curr.left);
                if(curr.right!=null)
                    q.add(curr.right);
            }
            System.out.println(total);
            if(maxi[1]<total)
            {
                maxi[0]=lvl;
                maxi[1]=total;
            }
            lvl++;
        }
        return maxi[0];
    }
}