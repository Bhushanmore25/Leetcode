class Solution {
    public static boolean canTake(int[] nums,int mid,int h)
    {
        int count=0;
        for(int i=0;i<nums.length;i++)
        {
            count += (nums[i] + mid - 1L) / mid;  
            if (count > h) return false;
        }
        return count <= h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=Arrays.stream(piles).max().getAsInt();
        int mid;
        while(low<=high)
        {
            mid=low+(high-low)/2;
            if(canTake(piles,mid,h))
            {
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}