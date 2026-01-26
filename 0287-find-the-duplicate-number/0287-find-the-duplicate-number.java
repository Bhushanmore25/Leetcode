class Solution {
    public int findDuplicate(int[] nums) {
        boolean [] seen= new boolean [100001];
        for(int num : nums){
            if(seen[num]){
                return num;
            }
            else{
                seen[num]=true;
            }
            
        }
        return -1;
    }
}