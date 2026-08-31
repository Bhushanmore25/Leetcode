class Solution {
    public int countSpecialIntegers(int[] nums) {
        int[] x=new int[101];
        int count=0;
        for(int i=0;i<nums.length;i++)
        {
            if(x[nums[i]]!=0 && nums[i-1]!=nums[i]) x[nums[i]]=-1;
            if(x[nums[i]]==-1) continue;
            x[nums[i]]+=1;
        }
        for(int i=0;i<101;i++) if(x[i]>0) count++;
        return count;
    }
}