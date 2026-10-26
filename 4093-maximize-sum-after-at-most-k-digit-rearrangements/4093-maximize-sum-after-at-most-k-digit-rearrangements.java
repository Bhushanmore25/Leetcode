class Solution {
    public int getDiff(int n){
        int val=n;
        List<Integer> li=new ArrayList<>();
        while(val!=0)
        {
            li.add(val%10);
            val/=10;
        }
        Collections.sort(li,Collections.reverseOrder());
        int newVal=0;
        for(int i=0;i<li.size();i++)
        {
            newVal=newVal*10+li.get(i);
        }
        return newVal-n;
    }
    public long maximizeSum(int[] nums, int k) {
        int[][] a=new int[nums.length][2];
        for(int i=0;i<nums.length;i++)
        {
            a[i][0]=i;
            a[i][1]=getDiff(nums[i]);
        }
        Arrays.sort(a,(x,y)->{
            if(x[1]==y[1])
                return x[0]-y[0];
            return y[1]-x[1];
        });
        long ans=0;
        for(int i=0;i<nums.length;i++)
        {
            if(i<k){
                ans+=(long) nums[a[i][0]] + (long)a[i][1];
            }
            else ans+=(long) nums[a[i][0]];
        }
        return ans;
    }
}