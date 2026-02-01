class Solution {
    public int minimumCost(int[] nums) {
        int[] freq=new int[51];
        for(int i:nums)
        {
            freq[i]++;
        }
        freq[nums[0]]--;
        int sum=nums[0],count=0;
        for(int i=0;i<51 && count<2;i++)
        {
            while(freq[i] > 0 && count < 2) {
                sum += i;   
                freq[i]--;
                count++;
            }
        }
        return sum;
    }
}