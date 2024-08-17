class Solution {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;
        int[] arr=new int[n];
        int j=0;
        int count=1;
        arr[0]=nums[0];
        for(int i=1;i<n;i++)
        {
            if (nums[i]!=arr[j]) {
                j++;
                count+=1;
                arr[j]=nums[i];
            }
        }
       for (int i = 0; i < nums.length; i++) {
            if (i<arr.length) {
                nums[i]=arr[i];
            }
            else{
                nums[i]=0;
            }
        }
        return count;
    }
}