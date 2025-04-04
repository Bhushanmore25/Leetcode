class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        Set<Integer> set1=new HashSet<>();
        Set<Integer> set2=new HashSet<>();
        for(int i:nums1) set1.add(i);
        for(int i:nums2) set2.add(i);
        int[] ans=new int[2];
        for(int i=0;i<nums1.length;i++)
        {
            if(set2.contains(nums1[i])) ans[0]++;
        }
        for(int i=0;i<nums2.length;i++)
        {
            if(set1.contains(nums2[i])) ans[1]++;
        }
        return ans;
    }
}