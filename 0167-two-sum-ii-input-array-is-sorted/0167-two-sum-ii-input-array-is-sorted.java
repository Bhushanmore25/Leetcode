class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left=0,right=numbers.length-1;
        int[] twos=new int[2];
        while(left<right)
        {
            int x=numbers[left]+numbers[right];
            if(x==target)
            {
                twos[0]=left+1;
                twos[1]=right+1;
                break;
            }
            else if(x>target)
            {
                right--;
            }
            else{
                left++;
            }
        }
        return twos;
    }
}