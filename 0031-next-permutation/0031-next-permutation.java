class Solution {
    public void nextPermutation(int[] nums) {
        int i=nums.length-2,dec=0;
        while(i>=0 && nums[i]>=nums[i+1])
        {
            i--;
        }
        if(i<0)
        {
            int l=0,r=nums.length-1;
            while(l<r)
            {
                int tp=nums[l];
                nums[l]=nums[r];
                nums[r]=tp;
                l++;
                r--;
            }
            return;
        }
        dec=i;
        int inc=dec+1,dist=Integer.MAX_VALUE;
        for(int j=dec+1;j<nums.length;j++)
        {
            if(nums[j]-nums[dec]>0 && nums[j]-nums[dec]<=dist)
            {
                dist=nums[j]-nums[dec];
                inc=j;
            }
        }
        // System.out.println(inc);
        int temp=nums[dec];
        nums[dec]=nums[inc];
        nums[inc]=temp;
        int l=dec+1,r=nums.length-1;
        while(l<r)
        {
            int tp=nums[l];
            nums[l]=nums[r];
            nums[r]=tp;
            l++;
            r--;
        }

    }
}