class Solution {
    public String[] largestString(int[] nums) {
        String[] ans =new String[nums.length];
        Map<Integer,Character> map=new HashMap<>();
        char ch='a';
        int val=1;
        for(int i=0;i<26;i++) {
            map.put(val,ch);
            ch++;
            val<<=1;
        }
        for(int x=0;x<nums.length;x++)
        {
            StringBuilder str=new StringBuilder();
            while(nums[x]!=0)
            {
                int i=1;
                while(i<=nums[x] && i <= 33_554_432) i<<=1;
                // if(i==nums[x]) {
                //     str.append(map.get(i));
                //     break;    
                // }
                i>>=1;
                str.append(map.get(i));
                nums[x]-=i;
            }
            ans[x]=str.toString();
        }
        return ans;
    }
}