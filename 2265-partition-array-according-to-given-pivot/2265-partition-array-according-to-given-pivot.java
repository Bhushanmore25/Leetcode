class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        ArrayList<Integer> small=new ArrayList<>();
        ArrayList<Integer> equal=new ArrayList<>();
        ArrayList<Integer> large=new ArrayList<>();
        for(int i:nums)
        {
            if(i==pivot)
                equal.add(i);
            else if(i<pivot)
                small.add(i);
            else
                large.add(i);
        }
        int k=0;
        for(int i=0;i<small.size();i++)
            nums[k++]=small.get(i);
        for(int i=0;i<equal.size();i++)
            nums[k++]=equal.get(i);
        for(int i=0;i<large.size();i++)
            nums[k++]=large.get(i);
        return nums;
    }
}