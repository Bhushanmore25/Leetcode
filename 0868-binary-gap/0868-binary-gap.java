class Solution {
    public int binaryGap(int n) {
        StringBuilder str=new StringBuilder();
        while(n!=0)
        {
            str.append(n%2);
            n/=2;
        }
        int prev=-1,ans=0;
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)=='1' && prev==-1) prev=i;
            else if(str.charAt(i)=='1') {
                ans=Math.max(ans,i-prev);
                prev=i;    
            }
        }
        return ans;
    }
}