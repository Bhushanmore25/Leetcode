class Solution {
    public boolean isTrionic(int[] nums) {
        int l=0,m=0,r=0,n=nums.length;
        // if(n==3) return false;
        while(l<n-1 && nums[l]<nums[l+1]) l++;
        m=l;
        while(m<n-1 && nums[m]>nums[m+1]) m++;
        r=m;
        while(r<n-1 && nums[r]<nums[r+1]) r++;
        if(l!=0 && l!=m && m!=r && r==n-1) return true;
        return false;
    }
}