class Solution {
    public void sortColors(int[] nums) {
        int[] number=new int[3];
        for(int i=0;i<nums.length;i++){
            number[nums[i]]++;
        }
        int k=0;
        for(int  i=0;i<nums.length;i++){
            while(number[k]==0)
            {
                k++;
            }
            nums[i]=k;
            number[k]--;
            if(number[k]==0)
            {
                k++;
            }
        }
    }
}