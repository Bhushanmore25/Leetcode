class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        backtrack(candidates,target,0,new ArrayList<>(),ans);
        return ans;
    }
    public static void backtrack(int candidates[],int target,int st,List<Integer> li,List<List<Integer>> ans)
    {
        if(target==0)
        {
            ans.add(new ArrayList<>(li));
            return;
        }
        for(int i=st;i<candidates.length;i++)
        {
            if(candidates[i]>target){
                continue;
            }
            li.add(candidates[i]);
            backtrack(candidates,target-candidates[i],i,li,ans);
            li.remove(li.size()-1);
        }
    }
}