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
    public static long dfs(TreeNode root,long total,long[] ans)
    {
        if(root==null) return 0;

        long temp=dfs(root.left,total,ans);
        temp+=dfs(root.right,total,ans);
        temp+=root.val;
        ans[0]=Math.max(ans[0],(total-temp)*temp);
        return temp;
    }
    public int maxProduct(TreeNode root) {
        int MOD=1000000007;
        long total=0;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode curr=q.poll();
                total+=(long)curr.val;
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
        }
        // System.out.println(total);
        long[] ans=new long[]{0};
        long sum=dfs(root,total,ans);
        ans[0]=ans[0]%MOD;
        return (int) ans[0];
    }
}