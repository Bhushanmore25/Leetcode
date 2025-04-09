class Solution {
    public int minOperations(int[] nums, int k) {
        HashSet<Integer> set=new HashSet<>();
        boolean isfound=false;
        boolean valid=true;
        for(int num:nums)
        {
            set.add(num);
            if(num<k) valid=false;
            if(num==k) isfound=true;
        }
        if(!valid) return -1;
        return isfound? set.size()-1:set.size(); 
    }
}