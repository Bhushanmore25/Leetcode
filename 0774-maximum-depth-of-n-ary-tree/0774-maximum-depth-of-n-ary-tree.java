/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public static void bfs(Node root,int[] maxi)
    {
        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        q.offer(null);
        int lvl=0;
        while(!q.isEmpty())
        {
            Node curr=q.poll();
            if(curr==null)
            {
                if(q.isEmpty())
                {
                    return;
                }
                else{
                    q.add(null);
                    lvl+=1;
                    maxi[0]=Math.max(maxi[0],lvl);
                }
            }
            else if(curr.children.size()>0)
            {
                for(int i=0;i<curr.children.size();i++)
                {
                    q.offer(curr.children.get(i));
                }
            }
        }
    }
    public int maxDepth(Node root) {
        if(root==null) return 0;
        int[] maxi={0};
        bfs(root,maxi);
        return maxi[0]+1;
    }
}