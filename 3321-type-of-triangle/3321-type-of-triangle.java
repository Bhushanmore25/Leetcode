class Solution {
    public String triangleType(int[] nums) {
        Arrays.sort(nums);
        boolean triangle= (nums[0]+nums[1] > nums[2]);
        if(!triangle) return "none";
        boolean equi=nums[0]==nums[1] && nums[1]==nums[2];
        if(equi) return "equilateral";
        boolean iso=nums[0]==nums[1] || nums[1]==nums[2] || nums[0]==nums[2];
        if(iso) return "isosceles";
        return "scalene";
    }
}