class Solution {
    public int countRatioSubarrays(int[] nums, int a, int b) {
        int odd=0,even =0,c=0;
        double rat= a/(1.0d*b);
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i;j<nums.length;j++)
            {
                if(nums[j]%2 == 0) even++;
                else odd++;
                double div= even/(1.0d*odd);
                if(div<=rat) c++;
            }
            even=0;
            odd=0;
        }
        return c;
    }
}