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
    public List<Integer> largestValues(TreeNode root) {
        ArrayList<Integer> result=new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> q=new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()){
            int size=q.size();
         int maxVal = Integer.MIN_VALUE;
            for(int i=1;i<=size;i++){
                TreeNode temp=q.poll();
                maxVal=Math.max(temp.val,maxVal);
                if(temp.left!=null){
                    q.offer(temp.left);
                }if(temp.right!=null){
                    q.offer(temp.right);
                }
            }
            result.add(maxVal);
        }
        return result;
    }
}