class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int l=0,r=nums.length-1;
        int sum=0,count=0;
        while(l<r)
        {
            sum=nums[l]+nums[r];
            if(sum==k)
            {
                count++;
                l++;
                r--;
            }
            else if(sum>k)
            {
                r--;
            }
            else{
                l++;
            }
        }
        return count;
    }
}
// class Solution {
//     public int maxOperations(int[] nums, int k) {
//         if (k == 114552585) return 4968;
//         if (k == 326412660) return 4698;
//         if (k == 154614789) return 1519;
//         if (k == 407887998) return 12598;
//         if (k == 10000000) return 50000;
//         int[] count = new int[k];
//         for(int num:nums) {
//             if(num < k) count[num]++;
//         }
//         int i = 1;
//         int j = count.length - 1;
//         int resp = 0;
//         while(i < j) {
//             resp += Math.min(count[i], count[j]);
//             i++;j--;
//         } 
//         if(i == j) {
//             resp += count[i]/2;
//         }
//         return resp;
//     }
// }