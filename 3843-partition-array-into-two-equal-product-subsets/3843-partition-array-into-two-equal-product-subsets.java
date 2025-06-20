class Solution {
    boolean[] used;

    public boolean checkEqualPartitions(int[] nums, long target) {
        int n = nums.length;
        used = new boolean[n];
        return help(nums, 0, 1, target, 0);
    }

    public boolean help(int[] nums, int in, long m, long t, int count){
        int n = nums.length;
        if(in==n){
            if(count==0 || count==n) return false;
            long p = 1;
            for(int i=0; i<n; i++){
                if(!used[i]) {
                    p*=nums[i];
                }
            }
            return (p==t && m==t);
        }
        used[in] = true;
        if (help(nums, in+1, m*nums[in], t, count+1)) return true;
        used[in] = false;
        if (help(nums, in+1, m, t, count)) return true;

        return false;
    }
}