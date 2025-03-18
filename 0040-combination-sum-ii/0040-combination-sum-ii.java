class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates,target,0,new ArrayList<>(),ans);
        return ans;
    }
    public static void backtrack(int candidates[],int target,int st,List<Integer> li,List<List<Integer>> ans)
    {
        if (target < 0) {
            return;
        }
        if(target==0)
        {
            if(!ans.contains(li))
                ans.add(new ArrayList<>(li));
            return;
        }
        for(int i=st;i<candidates.length;i++)
        {
            if (i > st && candidates[i] == candidates[i-1]) {
                continue;
            }
            if(candidates[i]>target){
                break;
            }
            li.add(candidates[i]);
            backtrack(candidates,target-candidates[i],i+1,li,ans);
            li.remove(li.size()-1);
            // backtrack(candidates,candidates[i],i+1,li,ans);
        }
    }
}