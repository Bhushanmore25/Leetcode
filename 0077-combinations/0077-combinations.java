class Solution {
    public static void helper(int start,int n,int k,List<List<Integer>> ans,List<Integer> li)
    {
        if(li.size()==k)
        {
            ans.add(new ArrayList<>(li));
            return;
        }
        for (int i = start; i <= n; i++) {  
            li.add(i);
            helper(i + 1, n, k, ans, li); 
            li.remove(li.size() - 1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans=new ArrayList<>();
        helper(1,n,k,ans,new ArrayList<>());
        return ans;
    }
}