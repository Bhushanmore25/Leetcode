class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int midx=m-1;
        int nidx=n-1;
        int rt=m+n-1;
        while(nidx>=0)
        {
            if(midx>=0 && nums1[midx]>nums2[nidx])
            {
                nums1[rt]=nums1[midx];
                midx--;
            }
            else{
                nums1[rt]=nums2[nidx];
                nidx--;
            }
            rt--;
        }
    }
}