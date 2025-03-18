class Solution {
    public static void helper(int idx,int sum,List<Integer> nums,List<List<Integer>> ans,int n, int k , List<Integer> li)
    {
        if(sum==n)
        {
            if(li.size()==k) ans.add(new ArrayList<>(li));
            return;
        }
        if (sum > n || idx >= nums.size()) return;
        li.add(nums.get(idx));
        helper(idx + 1, sum + nums.get(idx), nums, ans, n, k, li);
        li.remove(li.size() - 1);
        helper(idx + 1, sum, nums, ans, n, k, li);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> nums=new ArrayList<>();
        for(int i=1;i<=9;i++) nums.add(i);
        helper(0,0,nums,ans,n,k,new ArrayList<>());
        return ans;
    }
}