class Solution {
    public int[] searchRange(int[] nums, int target) {
        int var=-1;
        int[] arr={-1,-1};
        if (nums.length==0) {
            return arr;
        }
        for (int i = 0; i < nums.length; i++) {
            if (target==nums[i]) {
                if (var==-1) {
                    var=i;
                    arr[0]=i;
                }
                else{
                    var++;
                }
            }
        }
        arr[1]=var;
        return arr;
    }
}