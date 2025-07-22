class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int sum=0;
        HashSet<Integer> set=new HashSet<>();
        int l=0,maxi=Integer.MIN_VALUE;
        for(int r=0;r<nums.length;r++)
        {
            if(!set.contains(nums[r]))
            {
                set.add(nums[r]);
                sum+=nums[r];
                maxi=Math.max(maxi,sum);
            }
            else{
                while(set.contains(nums[r]))
                {
                    sum-=nums[l];
                    set.remove(nums[l]);
                    l++;
                }
                set.add(nums[r]);
                sum+=nums[r];
                maxi=Math.max(maxi,sum);
            }
        }
        return maxi;
    }
}