class Solution {
    public long maxProduct(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++) {
            nums[i]=Math.abs(nums[i]);
            System.out.println(nums[i]);
        }
        Arrays.sort(nums);
        long maxi1=-1,maxi2=-1;
        int idx=0;
        for(int i=0;i<n;i++)
        {
            if(maxi1<nums[i])
            {
                maxi1=Math.max(maxi1,nums[i]);
                idx=i;
            }
        }
        for(int i=0;i<n;i++)
        {
            if(i!=idx)
            maxi2=Math.max(maxi2,nums[i]);
        }
        System.out.println(maxi1+" "+maxi2);
        return maxi1 * maxi2 * 100000;
    }
}