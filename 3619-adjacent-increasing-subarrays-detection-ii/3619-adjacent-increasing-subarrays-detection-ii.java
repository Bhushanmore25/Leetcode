class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        List<Integer> li=new ArrayList<>();
        int count=1;
        for(int i=0;i<nums.size()-1;i++)
        {
            if(nums.get(i+1) > nums.get(i)) count++;
            else {
                li.add(count);
                count=1;
            }
        }
        li.add(count);
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<li.size()-1;i++)
        {
            maxi=Math.max(maxi,Math.max(li.get(i)/2,Math.min(li.get(i),li.get(i+1))));
        }
        maxi=Math.max(maxi,li.get(li.size()-1)/2);
        return maxi;
    }
}