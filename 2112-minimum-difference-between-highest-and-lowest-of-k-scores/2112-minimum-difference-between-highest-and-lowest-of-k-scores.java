class Solution {
    public int minimumDifference(int[] nums, int k) {
        
        Arrays.sort(nums);
        int n= nums.length;
        if(n==1){
            return 0;
        }
        int min_Diff=Integer.MAX_VALUE;
        for(int i=0;i<=n-k;i++){
            int max=nums[i+k-1];  
            int min=nums[i];  
            min_Diff=Math.min(min_Diff,max-min);
        }
        return min_Diff;
    }
}