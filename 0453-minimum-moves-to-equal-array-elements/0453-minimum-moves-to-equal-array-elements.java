import java.util.Arrays;
class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int min=nums[0];
        int moves=0;
        for(int i=0;i<nums.length;i++){
            moves+=nums[i]-min;
        }
        return moves;
    }
}