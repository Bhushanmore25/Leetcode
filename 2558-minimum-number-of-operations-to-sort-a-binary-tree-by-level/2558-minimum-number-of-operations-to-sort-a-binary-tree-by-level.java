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
    public static int getNoofSwaps(List<Integer> li)
    {
        int s=0;
        List<Integer> sorted=new ArrayList<>(li);
        Collections.sort(sorted);

        Map<Integer,Integer> hash=new HashMap<>();
        for(int i=0;i<li.size();i++)
        {
            hash.put(li.get(i),i);
        }

        for(int i=0;i<li.size();i++)
        {
            if(!li.get(i).equals(sorted.get(i)))
            {
                s++;
                int loc=hash.get(sorted.get(i));
                hash.put(li.get(i), loc);
                hash.put(sorted.get(i), i);
                Collections.swap(li, i, loc);
            }
        }
        return s;
    }
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int ans=0;
        while(!q.isEmpty())
        {
            int size=q.size();
            List<Integer> li=new ArrayList<>();
            for(int i=0;i<size;i++)
            {
                TreeNode node=q.poll();
                li.add(node.val);
                if(node.left!=null)
                {
                    q.add(node.left);
                }
                if(node.right!=null)
                {
                    q.add(node.right);
                }
            }
            ans+=getNoofSwaps(li);
        }
        return ans;
    }
}